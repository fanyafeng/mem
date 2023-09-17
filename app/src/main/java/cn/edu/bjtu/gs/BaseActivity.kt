package cn.edu.bjtu.gs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.cache.CacheDatabase
import cn.edu.bjtu.gs.cache.CacheModel
import cn.edu.bjtu.gs.event.LogoutEvent
import cn.edu.bjtu.gs.http.HttpParamsBuilderImpl
import cn.edu.bjtu.gs.main.login.LoginActivity
import cn.edu.bjtu.gs.main.login.manager.UserInfoManager
import cn.edu.bjtu.gs.main.login.model.UserInfoModel
import com.alibaba.fastjson.JSON
import com.ripple.dialog.custom.LoadingSimpleDialog
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.greenrobot.eventbus.EventBus

open class BaseActivity : AppCompatActivity() {

    private var loadingDialog: LoadingSimpleDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            if (UserInfoManager.getInstance().userInfo == null) {
                val dao = CacheDatabase.getDatabase(this@BaseActivity).cacheDao()
                val userInfoString = dao.query(UserInfoManager.USER_INFO_KEY)?.value
                if (!userInfoString.isNullOrEmpty()) {
                    val userInfo = JSON.parseObject(userInfoString, UserInfoModel::class.java)
                    UserInfoManager.getInstance().userInfo = userInfo
                }
            }
        }

        this.javaClass.getAnnotation(UserStatusSettingAnnotation::class.java)?.let {
            if (it.value) {
                runBlocking {
                    App.application?.let { application ->
                        val dao = CacheDatabase.getDatabase(application).cacheDao()
                        val token = dao.query(HttpParamsBuilderImpl.TOKEN)?.value
                        if (token.isNullOrEmpty()) {
                            finish()
                            startActivity(Intent(this@BaseActivity, LoginActivity::class.java))
                        }
                    }
                }
            }
        }
    }

    fun isLogin(): Boolean = runBlocking {
        if (App.application != null) {
            val dao = CacheDatabase.getDatabase(application).cacheDao()
            val token = dao.query(HttpParamsBuilderImpl.TOKEN)?.value
            !token.isNullOrEmpty()
        } else {
            false
        }
    }

    fun logout() {
        runBlocking {
            if (App.application != null) {
                val dao = CacheDatabase.getDatabase(application).cacheDao()
                dao.deleteItemByKey(HttpParamsBuilderImpl.TOKEN)
            }
        }
        EventBus.getDefault().post(LogoutEvent())
    }

    fun showLoadingDialog() {
        runOnUiThread {
            if (loadingDialog == null) {
                loadingDialog = LoadingSimpleDialog(this)
                loadingDialog?.show()
            }
        }
    }

    fun dismissLoadingDialog() {
        loadingDialog?.dismiss()
    }
}