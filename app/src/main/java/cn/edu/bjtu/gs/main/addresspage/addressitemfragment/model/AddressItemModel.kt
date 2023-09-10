package cn.edu.bjtu.gs.main.addresspage.addressitemfragment.model

import cn.edu.bjtu.gs.BaseModel
import net.sourceforge.pinyin4j.PinyinHelper

/**
 * Author: fanyafeng
 * Date: 2023/8/26 16:29
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class AddressItemModel : BaseModel {
    var headerId: Long? = null

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

    fun getNameHeaderId(): Long? {
        if (!name.isNullOrEmpty() && (name?.length ?: 0) > 0) {
            val resultCharList = PinyinHelper.toHanyuPinyinStringArray(name!![0])
            if (resultCharList.isNotEmpty()) {
                val resultChar = resultCharList[0]
                headerId = resultChar.toUpperCase().toLong()
            }
        }
        return headerId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AddressItemModel) return false

        if (createBy != other.createBy) return false
        if (createTime != other.createTime) return false
        if (updateBy != other.updateBy) return false
        if (updateTime != other.updateTime) return false
        if (remark != other.remark) return false
        if (id != other.id) return false
        if (number != other.number) return false
        if (idcard != other.idcard) return false
        if (type != other.type) return false
        if (userId != other.userId) return false
        if (region != other.region) return false
        if (industry != other.industry) return false
        if (hobby != other.hobby) return false
        if (advantage != other.advantage) return false
        if (unit != other.unit) return false
        if (title != other.title) return false
        if (delFlag != other.delFlag) return false
        if (name != other.name) return false
        if (phone != other.phone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = createBy?.hashCode() ?: 0
        result = 31 * result + (createTime?.hashCode() ?: 0)
        result = 31 * result + (updateBy?.hashCode() ?: 0)
        result = 31 * result + (updateTime?.hashCode() ?: 0)
        result = 31 * result + (remark?.hashCode() ?: 0)
        result = 31 * result + (id ?: 0)
        result = 31 * result + (number?.hashCode() ?: 0)
        result = 31 * result + (idcard?.hashCode() ?: 0)
        result = 31 * result + (type ?: 0)
        result = 31 * result + (userId ?: 0)
        result = 31 * result + (region ?: 0)
        result = 31 * result + (industry ?: 0)
        result = 31 * result + (hobby?.hashCode() ?: 0)
        result = 31 * result + (advantage?.hashCode() ?: 0)
        result = 31 * result + (unit?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (delFlag ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (phone?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "AddressItemModel(headerId=$headerId, createBy=$createBy, createTime=$createTime, updateBy=$updateBy, updateTime=$updateTime, remark=$remark, id=$id, number=$number, idcard=$idcard, type=$type, userId=$userId, region=$region, industry=$industry, hobby=$hobby, advantage=$advantage, unit=$unit, title=$title, delFlag=$delFlag, name=$name, phone=$phone)"
    }


}