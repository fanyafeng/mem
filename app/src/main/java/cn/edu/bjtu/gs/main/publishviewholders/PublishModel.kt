package cn.edu.bjtu.gs.main.publishviewholders

import cn.edu.bjtu.gs.BaseModel
import com.ripple.tool.kttypelians.UnitLambda

/**
 * Author: fanyafeng
 * Date: 2023/8/19 15:09
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class PublishModel(private val type: Int) : BaseModel {
    var title: String? = null
    var hintTitle: String? = null
    var result: String? = null
    var imageList: List<String>? = null
    var successLambda: UnitLambda = null

    fun getType(): Int {
        return type
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PublishModel) return false

        if (type != other.type) return false
        if (title != other.title) return false
        if (result != other.result) return false
        if (imageList != other.imageList) return false
        if (successLambda != other.successLambda) return false

        return true
    }

    override fun hashCode(): Int {
        var result1 = type
        result1 = 31 * result1 + (title?.hashCode() ?: 0)
        result1 = 31 * result1 + (result?.hashCode() ?: 0)
        result1 = 31 * result1 + (imageList?.hashCode() ?: 0)
        result1 = 31 * result1 + (successLambda?.hashCode() ?: 0)
        return result1
    }


}