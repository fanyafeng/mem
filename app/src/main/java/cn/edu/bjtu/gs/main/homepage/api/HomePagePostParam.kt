package cn.edu.bjtu.gs.main.homepage.api

import cn.edu.bjtu.gs.http.HttpRequestParamsImpl
import cn.edu.bjtu.gs.url.Urls
import com.ripple.http.base.annotation.HttpRequest

/**
 * Author: fanyafeng
 * Date: 2023/8/17 16:16
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng

@HttpRequest(Urls.URL_BULLETIN_LIST)
class HomePagePostParam : HttpRequestParamsImpl() {
    var status: String? = null
    var enrollStatus: String? = null
    var enrollment: String? = null
}