package com.example.retrofit_sample.Interface;

import com.example.retrofit_sample.DataModel.PostDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("v1/match?p1=1046&p2=1079") // Relative url, the absolute its declared elsewhere
    Call<List<PostDataModel>> getPosts();


}
