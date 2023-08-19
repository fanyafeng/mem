package cn.edu.bjtu.gs.main.notification.api

import cn.edu.bjtu.gs.BaseModel
import cn.edu.bjtu.gs.main.notification.NotificationModel

/**
 * Author: fanyafeng
 * Date: 2023/8/19 10:00
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class NotificationResponse : BaseModel {
    var total: Int? = null
    var tows: List<NotificationModel>? = null
    var code: Int? = null
    var message: String? = null
    override fun toString(): String {
        return "NotificationResponse(total=$total, tows=$tows, code=$code, message=$message)"
    }


}