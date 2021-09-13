package com.deibidc.jdcstmdb.conexion;

import com.deibidc.jdcstmdb.modelo.RetroPlaying;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataServicePlaying {

    @GET("now_playing")
    Call<RetroPlaying> getAllPlaying(
            @Query(value = "api_key")  String api_key,
            @Query(value = "language")   String language,
            @Query(value = "page")   String page
    );
}
