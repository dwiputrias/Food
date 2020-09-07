package com.dwiputri.greatfood.CRUD_Survey;

import com.dwiputri.greatfood.CRUD.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APISurvey {
    @FormUrlEncoded
    @POST("insert_survey.php")
    Call<ResponsSurvey> sendSurvey(@Field("nama") String nama,
                                   @Field("persen") String persen);

    @GET("read_survey.php")
    Call<ResponsSurvey> getSurvey();

    @FormUrlEncoded
    @POST("update_survey.php")
    Call<ResponsSurvey> updateSurvey( @Field("id_survey") String id_survey,
                                   @Field("nama") String nama,
                                   @Field("persen") String persen);

    @FormUrlEncoded
    @POST("delete_survey.php")
    Call<ResponsSurvey> deleteSurvey(@Field("id_survey") String id_survey);
}
