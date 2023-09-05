package cn.edu.bjtu.gs.main.homepage

import cn.edu.bjtu.gs.BaseModel

/**
 * Author: fanyafeng
 * Date: 2023/8/17 15:42
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class HomePageModel : BaseModel {
    var id: Int? = null
    var title: String? = null
    var type: Int? = null
    var startTime: String? = null
    var endTime: String? = null
    var address: String? = null
    var volume: Int? = null
    var enrollStartTime: String? = null
    var enrollEndTime: String? = null
    var cancelEndTime: String? = null
    var tag: String? = null
    var content: String? = null
    var process: Int? = null
    var picture: String? = null
    var delFlag: Int? = null
    var status: Int? = null
    var enrollStatus: Int? = null
    var enrollment: Int? = null
    var userId: Int? = null
    var userName: String? = null
    var participationStatus: Int? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HomePageModel) return false

        if (id != other.id) return false
        if (title != other.title) return false
        if (type != other.type) return false
        if (startTime != other.startTime) return false
        if (endTime != other.endTime) return false
        if (address != other.address) return false
        if (volume != other.volume) return false
        if (enrollStartTime != other.enrollStartTime) return false
        if (enrollEndTime != other.enrollEndTime) return false
        if (cancelEndTime != other.cancelEndTime) return false
        if (tag != other.tag) return false
        if (content != other.content) return false
        if (process != other.process) return false
        if (picture != other.picture) return false
        if (delFlag != other.delFlag) return false
        if (status != other.status) return false
        if (enrollStatus != other.enrollStatus) return false
        if (enrollment != other.enrollment) return false
        if (userId != other.userId) return false
        if (userName != other.userName) return false
        if (participationStatus != other.participationStatus) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (type ?: 0)
        result = 31 * result + (startTime?.hashCode() ?: 0)
        result = 31 * result + (endTime?.hashCode() ?: 0)
        result = 31 * result + (address?.hashCode() ?: 0)
        result = 31 * result + (volume ?: 0)
        result = 31 * result + (enrollStartTime?.hashCode() ?: 0)
        result = 31 * result + (enrollEndTime?.hashCode() ?: 0)
        result = 31 * result + (cancelEndTime?.hashCode() ?: 0)
        result = 31 * result + (tag?.hashCode() ?: 0)
        result = 31 * result + (content?.hashCode() ?: 0)
        result = 31 * result + (process ?: 0)
        result = 31 * result + (picture?.hashCode() ?: 0)
        result = 31 * result + (delFlag ?: 0)
        result = 31 * result + (status ?: 0)
        result = 31 * result + (enrollStatus ?: 0)
        result = 31 * result + (enrollment ?: 0)
        result = 31 * result + (userId ?: 0)
        result = 31 * result + (userName?.hashCode() ?: 0)
        result = 31 * result + (participationStatus ?: 0)
        return result
    }

    override fun toString(): String {
        return "HomePageModel(id=$id, title=$title, type=$type, startTime=$startTime, endTime=$endTime, address=$address, volume=$volume, enrollStartTime=$enrollStartTime, enrollEndTime=$enrollEndTime, cancelEndTime=$cancelEndTime, tag=$tag, content=$content, process=$process, picture=$picture, delFlag=$delFlag, status=$status, enrollStatus=$enrollStatus, enrollment=$enrollment, userId=$userId, userName=$userName, participationStatus=$participationStatus)"
    }


}