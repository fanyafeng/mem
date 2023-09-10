package cn.edu.bjtu.gs.appconfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/**
 * Author: fanyafeng
 * Date: 2023/9/9 14:24
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


public class RetryIntercepter implements Interceptor {

    private final int maxRetry;//最大重试次数
    private int retryNum = 0;//假如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）

    public RetryIntercepter(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        while (!response.isSuccessful() && retryNum < maxRetry) {
            retryNum++;
            Util.closeQuietly(response);
            response = chain.proceed(request);
        }
        return response;
    }
}
