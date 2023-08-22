package cn.edu.bjtu.gs.main.login.model

import cn.edu.bjtu.gs.BaseModel
import com.alibaba.fastjson.JSON

/**
 * Author: fanyafeng
 * Date: 2023/8/22 15:09
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class UserInfoModel : BaseModel {
    //    "avatar": "/profile/avatar/2023/08/16/a77a9ac21fc7d0c9197cd89d09255136_1_20230816132923A001.jpg",
    var createBy: String? = null
    var createTime: String? = null
    var updateBy: String? = null
    var updateTime: String? = null
    var remark: String? = null
    var id: Int? = null
    var number: String? = null
    var idcard: String? = null
    var type: Int? = null
    var userId: Int? = null
    var region: Int? = null
    var industry: Int? = null
    var hobby: String? = null
    var advantage: String? = null
    var unit: String? = null
    var title: String? = null
    var delFlag: Int? = null
    var name: String? = null
    var phone: String? = null
    var email: String? = null
    var wechat: String? = null
    var constellation: String? = null
    var avatar: String? = null
    var nickName: String? = null
    var userName: String? = null

    fun jsonString(): String {
        return JSON.toJSONString(this)
    }
}