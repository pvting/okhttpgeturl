package com.example.retrofit;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RedirectInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl beforeUrl = request.url();
        Response response = chain.proceed(request);
        HttpUrl afterUrl = response.request().url();
        String str  = response.header("Location");
        //1.根据url判断是否是重定向
        if (str.startsWith("//cache1.361lu.com")) {
            System.out.println("https:"+str);
            return null;
        }
        return response;
    }
}
