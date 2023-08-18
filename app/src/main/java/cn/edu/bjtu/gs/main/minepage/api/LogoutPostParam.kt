package cn.edu.bjtu.gs.main.minepage.api

import cn.edu.bjtu.gs.http.HttpRequestParamsImpl
import cn.edu.bjtu.gs.url.Urls
import com.ripple.http.base.annotation.HttpRequest

/**
 * Author: fanyafeng
 * Date: 2023/8/18 17:23
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng

@HttpRequest(Urls.URL_LOGOUT)
class LogoutPostParam : HttpRequestParamsImpl() {

}