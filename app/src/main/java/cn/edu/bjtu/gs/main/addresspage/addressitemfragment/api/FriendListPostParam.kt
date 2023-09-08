package cn.edu.bjtu.gs.main.addresspage.addressitemfragment.api

import cn.edu.bjtu.gs.http.HttpRequestParamsImpl
import cn.edu.bjtu.gs.url.Urls
import com.ripple.http.base.annotation.HttpRequest

/**
 * Author: fanyafeng
 * Date: 2023/9/7 19:25
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


@HttpRequest(Urls.URL_FRIEND_LIST)
class FriendListPostParam : HttpRequestParamsImpl() {
    var searchType: Int? = 4
    var searchInfo: String? = "篮球"
    var personId: Int? = 1
}