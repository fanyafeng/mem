package cn.edu.bjtu.gs.appconfig;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Author: fanyafeng
 * Date: 2023/9/9 14:26
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


public class HttpsHelper {
    public static SSLSocketFactory getSSLSocketFactory() {
        return getTrustAllContext().getSocketFactory();
    }

    public static HostnameVerifier getHostnameVerifier() {
        return new NormalHostnameVerifier();
    }

    public static X509TrustManager getX509TrustManager() {
        return new TrustAnyTrustManager();
    }

    private static SSLContext getTrustAllContext() {
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new SecureRandom());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sslContext;
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class NormalHostnameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
