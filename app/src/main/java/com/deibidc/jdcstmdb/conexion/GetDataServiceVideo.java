package com.deibidc.jdcstmdb.conexion;

import com.deibidc.jdcstmdb.modelo.RetroVideo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataServiceVideo {

    @GET("videos")
    Call<RetroVideo> getAllVideos(
            @Query(value = "api_key")  String api_key,
            @Query(value = "language")   String language
    );
}
