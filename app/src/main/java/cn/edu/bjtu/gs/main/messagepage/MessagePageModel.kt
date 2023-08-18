package cn.edu.bjtu.gs.main.messagepage

import cn.edu.bjtu.gs.BaseModel

/**
 * Author: fanyafeng
 * Date: 2023/8/18 14:23
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MessagePageModel(private val type: Int) : BaseModel {


    fun getType(): Int {
        return type
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MessagePageModel) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}