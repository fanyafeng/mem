package cn.edu.bjtu.gs.http

import com.ripple.http.base.IRequestParams
import com.ripple.http.base.IResponseParser
import com.ripple.http.base.abs.AbsHttpResponse


/**
 * Author: fanyafeng
 * Data: 2023/7/19 11:34
 * Email: fanyafeng@live.cn
 * Description:
 *
 *
 *///Github See: https://github.com/fanyafeng


class HttpResponseImpl(
    override var requestParams: IRequestParams.IHttpRequestParams
) : AbsHttpResponse() {
    override var parser: IResponseParser = HttpResponseParserImpl()
}