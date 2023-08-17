package cn.edu.bjtu.gs.main.minepage

import cn.edu.bjtu.gs.BaseModel

/**
 * Author: fanyafeng
 * Date: 2023/8/11 10:54
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class MinePageModel(private val type: Int) : BaseModel {

    var title: String? = null
    var subTitle: String? = null
    var clazz: Class<*>? = null

    fun getType(): Int {
        return type
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MinePageModel) return false

        if (type != other.type) return false
        if (title != other.title) return false
        if (subTitle != other.subTitle) return false
        if (clazz != other.clazz) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (subTitle?.hashCode() ?: 0)
        result = 31 * result + (clazz?.hashCode() ?: 0)
        return result
    }
}