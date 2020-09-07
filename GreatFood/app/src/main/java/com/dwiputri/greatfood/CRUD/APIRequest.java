package com.dwiputri.greatfood.CRUD;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequest {
    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponsModel> sendTanaman(@Field("nama") String nama,
                                   @Field("harga") String harga,
                                   @Field("deskripsi") String deskripsi);

    @GET("read.php")
    Call<ResponsModel> getTanaman();

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponsModel> updateData( @Field("id") String id,
                                   @Field("nama") String nama,
                                   @Field("harga") String harga,
                                   @Field("deskripsi") String deskripsi);

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponsModel> deleteData(@Field("id") String id);
}
