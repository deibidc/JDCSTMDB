package com.deibidc.jdcstmdb.conexion;

import com.deibidc.jdcstmdb.modelo.RetroPopular;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("popular")
    Call<RetroPopular> getAllPopulares(
            @Query(value = "api_key")  String api_key,
            @Query(value = "language")   String language,
            @Query(value = "page")   String page
    );
}
