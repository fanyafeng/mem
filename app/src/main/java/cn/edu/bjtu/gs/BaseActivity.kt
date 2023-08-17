package cn.edu.bjtu.gs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import cn.edu.bjtu.gs.annon.ActivityAnnotation
import cn.edu.bjtu.gs.cache.CacheDatabase
import cn.edu.bjtu.gs.http.HttpParamsBuilderImpl
import cn.edu.bjtu.gs.main.login.LoginActivity
import kotlinx.coroutines.runBlocking

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.javaClass.getAnnotation(ActivityAnnotation::class.java)?.let {
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
}