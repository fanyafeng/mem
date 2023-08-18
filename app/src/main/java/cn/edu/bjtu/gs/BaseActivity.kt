package cn.edu.bjtu.gs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.edu.bjtu.gs.annon.UserStatusSettingAnnotation
import cn.edu.bjtu.gs.cache.CacheDatabase
import cn.edu.bjtu.gs.http.HttpParamsBuilderImpl
import cn.edu.bjtu.gs.main.login.LoginActivity
import com.ripple.dialog.custom.LoadingSimpleDialog
import kotlinx.coroutines.runBlocking

open class BaseActivity : AppCompatActivity() {

    private var loadingDialog: LoadingSimpleDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    fun showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = LoadingSimpleDialog(this)
            loadingDialog?.show()
        }
    }

    fun dismissLoadingDialog() {
        loadingDialog?.dismiss()
    }
}