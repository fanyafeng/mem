package cn.edu.bjtu.gs.appconfig;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Author: fanyafeng
 * Date: 2023/9/9 14:23
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng

@com.bumptech.glide.annotation.GlideModule
public class GlideModule extends AppGlideModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        long memoryCacheSize = 30 * 1024 * 1024L;
        int diskCacheSize = 250 * 1024 * 1024;
        String diskCacheName = "glide_image_cache";

        builder.setMemoryCache(new LruResourceCache(memoryCacheSize));
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, diskCacheName, diskCacheSize));
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30L, TimeUnit.SECONDS)
                .writeTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .addInterceptor(new RetryIntercepter(3))
                .sslSocketFactory(HttpsHelper.getSSLSocketFactory(), HttpsHelper.getX509TrustManager())
                .hostnameVerifier(HttpsHelper.getHostnameVerifier())
                .build();
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(client));
    }
}