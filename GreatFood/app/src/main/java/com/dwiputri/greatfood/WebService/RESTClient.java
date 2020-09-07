package com.dwiputri.greatfood.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RESTClient {
    private static APIHasilLokasi REST_CLIENT;

    static {
        setupRstClient();
    }

    private RESTClient() {}

    public static APIHasilLokasi get() {
        return REST_CLIENT;
    }

    private static void setupRstClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.85/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        REST_CLIENT = retrofit.create(APIHasilLokasi.class);
    }
}
