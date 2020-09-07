package com.dwiputri.greatfood.WebService;

import retrofit2.Call;
import retrofit2.http.POST;

interface APIHasilLokasi {
    @POST("/great_food/lokasi")
    Call<ResponseHasilLokasi> getHasilLocate();
}
