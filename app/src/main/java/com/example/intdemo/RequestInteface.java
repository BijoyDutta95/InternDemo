package com.example.intdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInteface {
    @GET("photos")
    Call<List<DataModel>> getDataJson();
}
