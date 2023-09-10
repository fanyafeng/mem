package cn.edu.bjtu.gs.main.dialog.industrydialog

import cn.edu.bjtu.gs.BaseModel

/**
 * Author: fanyafeng
 * Date: 2023/9/10 14:46
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class IndustryModel : BaseModel {

    var createBy: String? = null
    var createTime: String? = null
    var updateBy: String? = null
    var updateTime: String? = null
    var remark: String? = null
    var dictCode: Int? = null
    var dictSort: Int? = null
    var dictLabel: String? = null
    var dictValue: String? = null
    var dictType: String? = null
    var cssClass: String? = null
    var listClass: String? = null
    var isDefault: String? = null
    var status: String? = null
    var default: Boolean? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is IndustryModel) return false

        if (createBy != other.createBy) return false
        if (createTime != other.createTime) return false
        if (updateBy != other.updateBy) return false
        if (updateTime != other.updateTime) return false
        if (remark != other.remark) return false
        if (dictCode != other.dictCode) return false
        if (dictSort != other.dictSort) return false
        if (dictLabel != other.dictLabel) return false
        if (dictValue != other.dictValue) return false
        if (dictType != other.dictType) return false
        if (cssClass != other.cssClass) return false
        if (listClass != other.listClass) return false
        if (isDefault != other.isDefault) return false
        if (status != other.status) return false
        if (default != other.default) return false

        return true
    }

    override fun hashCode(): Int {
        var result = createBy?.hashCode() ?: 0
        result = 31 * result + (createTime?.hashCode() ?: 0)
        result = 31 * result + (updateBy?.hashCode() ?: 0)
        result = 31 * result + (updateTime?.hashCode() ?: 0)
        result = 31 * result + (remark?.hashCode() ?: 0)
        result = 31 * result + (dictCode ?: 0)
        result = 31 * result + (dictSort ?: 0)
        result = 31 * result + (dictLabel?.hashCode() ?: 0)
        result = 31 * result + (dictValue?.hashCode() ?: 0)
        result = 31 * result + (dictType?.hashCode() ?: 0)
        result = 31 * result + (cssClass?.hashCode() ?: 0)
        result = 31 * result + (listClass?.hashCode() ?: 0)
        result = 31 * result + (isDefault?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (default?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "IndustryModel(createBy=$createBy, createTime=$createTime, updateBy=$updateBy, updateTime=$updateTime, remark=$remark, dictCode=$dictCode, dictSort=$dictSort, dictLabel=$dictLabel, dictValue=$dictValue, dictType=$dictType, cssClass=$cssClass, listClass=$listClass, isDefault=$isDefault, status=$status, default=$default)"
    }


}