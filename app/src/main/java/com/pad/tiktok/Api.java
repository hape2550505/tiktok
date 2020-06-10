package com.pad.tiktok;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("invoke/video/invoke/video")
    Call<List<VideoInfo>> getArticles();
}