package cn.edu.bjtu.gs.main.notification.api

import cn.edu.bjtu.gs.http.HttpRequestParamsImpl
import cn.edu.bjtu.gs.url.Urls
import com.ripple.http.base.annotation.HttpRequest

/**
 * Author: fanyafeng
 * Date: 2023/8/19 10:00
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


@HttpRequest(Urls.URL_INFO_LIST)
class NotificationPostParam : HttpRequestParamsImpl() {
    var personId: String = "1"
    var infoType: String = "1"
    var status: String = ""
}