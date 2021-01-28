package com.fuzaylofficial.arviewtask.RetrofitData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetGames {
    @GET("top")
    Call<Games> getGames();

    @GET("top")
    Call<Games> getNextGames(@Query("after") String cursor);


    @GET("top")
    Call<Games> getPreviousGames(@Query("before") String cursor);

}
