package cn.edu.bjtu.gs.http

import com.ripple.http.base.HttpMethod
import com.ripple.http.base.IHttpResponse
import com.ripple.http.base.IParamsBuilder
import com.ripple.http.base.IRequestParams
import com.ripple.http.base.abs.AbsHttpRequestParams
import com.ripple.http.base.annotation.HttpIgnoreBuildParam

/**
 * Author: fanyafeng
 * Data: 2023/7/19 12:04
 * Email: fanyafeng@live.cn
 * Description:
 *
 *
 *///Github See: https://github.com/fanyafeng


@HttpIgnoreBuildParam
open class HttpRequestParamsImpl(url: String = "") : AbsHttpRequestParams(url) {
    override fun getDefaultParamBuilder(): IParamsBuilder<IRequestParams.IHttpRequestParams> {
        return HttpParamsBuilderImpl()
    }

    override var response: IHttpResponse = HttpResponseImpl(this)

    override fun isUseJsonFormat(): Boolean {
        return true
    }

    override var method: HttpMethod = HttpMethod.POST
}