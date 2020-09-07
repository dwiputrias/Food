package com.dwiputri.greatfood.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class REST {
    private static APIHasilSurvey REST;

    static {
        setupRstClient();
    }

    private REST() {}

    public static APIHasilSurvey get() {
        return REST;
    }

    private static void setupRstClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.85/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        REST = retrofit.create(APIHasilSurvey.class);
    }
}
