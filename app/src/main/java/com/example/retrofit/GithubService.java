package com.example.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GithubService {
    @GET("/download_hd.php")
    Call<ResponseBody> getUserString(@Query("id") String id);
}
