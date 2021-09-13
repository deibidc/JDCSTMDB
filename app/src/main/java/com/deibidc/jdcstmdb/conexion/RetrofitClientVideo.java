package com.deibidc.jdcstmdb.conexion;

import android.content.Context;
import android.content.SharedPreferences;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitClientVideo {

    private static Retrofit retrofit;
    public static String idMovie = "";
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            String url = BASE_URL + idMovie;
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
