package cn.edu.bjtu.gs.http

import com.ripple.http.base.IRequestParams
import com.ripple.http.base.abs.AbsHttpParamsBuilder


/**
 * Author: fanyafeng
 * Data: 2023/7/19 11:04
 * Email: fanyafeng@live.cn
 * Description:
 *
 *
 *///Github See: https://github.com/fanyafeng


class HttpParamsBuilderImpl : AbsHttpParamsBuilder() {
    override fun getDefaultHost(): String {
        return "https://www.baidu.com"
    }

    override fun getUserAgent(): String {
        return "android"
    }
}