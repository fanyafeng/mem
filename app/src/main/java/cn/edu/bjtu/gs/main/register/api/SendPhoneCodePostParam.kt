package cn.edu.bjtu.gs.main.register.api

import cn.edu.bjtu.gs.http.HttpRequestParamsImpl
import cn.edu.bjtu.gs.url.Urls
import com.ripple.http.base.HttpMethod
import com.ripple.http.base.annotation.HttpRequest

/**
 * Author: fanyafeng
 * Date: 2023/8/18 10:43
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


@HttpRequest(Urls.URL_SEND_PHONE_CODE)
class SendPhoneCodePostParam : HttpRequestParamsImpl() {
    var phone: String = ""

    override var method: HttpMethod = HttpMethod.GET
}