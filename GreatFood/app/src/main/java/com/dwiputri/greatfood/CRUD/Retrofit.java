package com.dwiputri.greatfood.CRUD;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private  static  final String base_url = "http://192.168.43.85/great_food/";

    private static retrofit2.Retrofit retrofit;


    public static retrofit2.Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
}
