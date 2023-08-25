package cn.edu.bjtu.gs.main.publishviewholders

import cn.edu.bjtu.gs.BaseModel

/**
 * Author: fanyafeng
 * Date: 2023/8/19 15:09
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishModel(private val type: Int) : BaseModel {

    fun getType(): Int {
        return type
    }

    var result: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PublishModel) return false

        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        return type
    }


}