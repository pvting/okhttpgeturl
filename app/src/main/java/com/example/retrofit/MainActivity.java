package com.example.retrofit;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    String BASE_URL = "https://youavtube.com/";
    String name = "";

    String  url  = "https://youavtube.com/download_hd.php?id=";

     OkHttpClient mOkHttpClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mOkHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new RedirectInterceptor())
                .build();
         new Thread(){
             @Override
             public void run() {
                 for (int i = 1; i <= 500; i++) {
                     okhttp(i);
                     SystemClock.sleep(100);
                 }
             }
         }.start();

    }
    public void okhttp(final int i) {
        new Thread(){
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url(url+i)
                        .build();
                try{
                    mOkHttpClient.newCall(request).execute();
                }catch (Exception e){
                    new Gson();
                }
            }
        }.start();
    }
}

