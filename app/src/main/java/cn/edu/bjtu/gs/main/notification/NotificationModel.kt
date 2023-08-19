package cn.edu.bjtu.gs.main.notification

import cn.edu.bjtu.gs.BaseModel

/**
 * Author: fanyafeng
 * Date: 2023/8/19 09:21
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class NotificationModel : BaseModel {

    var id: Int? = null
    var personId: String? = null
    var friendId: String? = null
    var infoType: String? = null
    var infoBody: String? = null
    var status: Int? = null
    var creatTime: String? = null
    var handleTime: String? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NotificationModel) return false

        if (id != other.id) return false
        if (personId != other.personId) return false
        if (friendId != other.friendId) return false
        if (infoType != other.infoType) return false
        if (infoBody != other.infoBody) return false
        if (status != other.status) return false
        if (creatTime != other.creatTime) return false
        if (handleTime != other.handleTime) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (personId?.hashCode() ?: 0)
        result = 31 * result + (friendId?.hashCode() ?: 0)
        result = 31 * result + (infoType?.hashCode() ?: 0)
        result = 31 * result + (infoBody?.hashCode() ?: 0)
        result = 31 * result + (status ?: 0)
        result = 31 * result + (creatTime?.hashCode() ?: 0)
        result = 31 * result + (handleTime?.hashCode() ?: 0)
        return result
    }

}