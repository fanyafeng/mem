package cn.edu.bjtu.gs.main.dialog.industrydialog

import cn.edu.bjtu.gs.http.HttpRequestParamsImpl

/**
 * Author: fanyafeng
 * Date: 2023/9/10 14:48
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


//@HttpRequest(Urls.URL_INDUSTRY)
class IndustryGetParams(private val targetUrl: String) : HttpRequestParamsImpl(targetUrl) {
    var id: Int? = null

    override fun getUrl(): String {
        return targetUrl
    }
}