package cn.edu.bjtu.gs.main.homepage

import cn.edu.bjtu.gs.BaseModel

/**
 * Author: fanyafeng
 * Date: 2023/8/17 15:42
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class HomePageModel : BaseModel {

    var title: String? = null
    var startTime: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HomePageModel) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}