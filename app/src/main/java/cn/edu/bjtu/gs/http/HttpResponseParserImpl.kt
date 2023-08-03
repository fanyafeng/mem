package cn.edu.bjtu.gs.http

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ripple.http.base.IHttpResponse
import com.ripple.http.base.abs.AbsHttpResponseParser


/**
 * Author: fanyafeng
 * Data: 2023/7/19 11:40
 * Email: fanyafeng@live.cn
 * Description:
 *
 *
 *///Github See: https://github.com/fanyafeng


open class HttpResponseParserImpl : AbsHttpResponseParser() {
    override fun <T> parseData(
        jsonObject: JSONObject,
        response: IHttpResponse
    ): T {
        response.code = jsonObject.getString("code")
//        response.success = jsonObject.getBoolean("success")
        response.message = jsonObject.getString("msg")
        response.data = jsonObject.getString("data")
        val itemClazz = response.itemKClass
        return JSON.parseObject<T>(response.data, itemClazz)
    }
}