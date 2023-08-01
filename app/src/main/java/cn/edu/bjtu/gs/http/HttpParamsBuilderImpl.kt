package cn.edu.bjtu.gs.http

import cn.edu.bjtu.gs.App
import cn.edu.bjtu.gs.cache.CacheDatabase
import cn.edu.bjtu.gs.main.url.Urls
import com.ripple.http.base.IRequestParams
import com.ripple.http.base.abs.AbsHttpParamsBuilder
import kotlinx.coroutines.runBlocking


/**
 * Author: fanyafeng
 * Data: 2023/7/19 11:04
 * Email: fanyafeng@live.cn
 * Description:
 *
 *
 *///Github See: https://github.com/fanyafeng


class HttpParamsBuilderImpl : AbsHttpParamsBuilder() {

    companion object {
        const val TOKEN = "token"
    }

    override fun getDefaultHost(): String {
        return Urls.BASE_URL
    }

    override fun getUserAgent(): String {
        return "android"
    }

    override fun buildParams(params: IRequestParams.IHttpRequestParams) {
        super.buildParams(params)
//        val header = params.getHeader()
        runBlocking {
            App.application?.let {
                val dao = CacheDatabase.getDatabase(it).cacheDao()
                dao.query(TOKEN)?.value?.let { token ->
                    params.addHeader(TOKEN, token)
                }
            }
        }
    }
}