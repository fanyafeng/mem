package cn.edu.bjtu.gs.http

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.ripple.http.base.IHttpResponse
import com.ripple.http.base.abs.AbsHttpResponseParser
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.javaType
import kotlin.reflect.typeOf


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

//        return Gson().fromJson<T>(response.data, itemClazz)
//        return JSON.parseObject<T>(response.data, itemClazz)


        return if (response.isListResult) {
            JSON.parseArray(
                response.data,
                (response.itemKType!!.classifier as KClass<*>).java
            ) as T
        } else {
            JSON.parseObject<T>(response.data, itemClazz)
        }
    }


}