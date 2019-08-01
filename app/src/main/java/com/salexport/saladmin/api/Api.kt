package com.salexport.saladmin.api

import com.salexport.saladmin.models.LoginResponse
import com.salexport.saladmin.models.NotificationResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("notifications")
    fun getNotifications():Call<NotificationResponse>

    @FormUrlEncoded
    @POST("oauth/token")
    fun login(
        @Field("grant_type") grant_type: String,
        @Field("client_id") client_id: String,
        @Field("client_secret") client_secret: String,
        @Field("username") username: String,
        @Field("password") password: String
    ):Call<LoginResponse>
}