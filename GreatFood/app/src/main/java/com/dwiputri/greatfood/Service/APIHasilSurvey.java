package com.dwiputri.greatfood.Service;

import retrofit2.Call;
import retrofit2.http.POST;

interface APIHasilSurvey {
    @POST("/great_food/survey")
    Call<ResponseHasilSurvey> getHasilSurveyy();
}
