package com.emerycp.client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service {

    @POST("init")
    Call<Void> toInit ();

    @POST("click")
    Call<User> toClick (@Body LoginRequest logR);

    @POST("create")
    Call<Boolean> toCreate (@Body LoginRequest logR);

    @GET("howmany/{id}")
    Call<User> toMany (@Path("id") int id);
}
