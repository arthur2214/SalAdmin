package com.salexport.saladmin

import com.salexport.saladmin.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitClient {

    private const val BASE_URL = "https://dev.motorgrupo.network/"

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)
        .addInterceptor { chain ->

            val original = chain.request()

            val requestBuilder = original.newBuilder()
                //.addHeader("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImVmNjIzODAzMGFhNDc1ZDg3YTRjN2M1NWZjMzFmNTA2ZmQzOTQxMzBkZDZkZWM5NDZhZDRkN2NiOWZmZDk5M2FkMGZiMGQ1OTQ1MDJmYzA2In0.eyJhdWQiOiI3IiwianRpIjoiZWY2MjM4MDMwYWE0NzVkODdhNGM3YzU1ZmMzMWY1MDZmZDM5NDEzMGRkNmRlYzk0NmFkNGQ3Y2I5ZmZkOTkzYWQwZmIwZDU5NDUwMmZjMDYiLCJpYXQiOjE1NjIyMjA3NzcsIm5iZiI6MTU2MjIyMDc3NywiZXhwIjoxNTkzODQzMTc3LCJzdWIiOiIxMiIsInNjb3BlcyI6W119.FyXjKnmb47F7Sbv_nY5m8LS4qBfxxdMQNbYNd-Z8458uG3CAQdFJ-PhzKpu_IBYdSj-SJCWpjyUWGNLXCxyARH9MrjxlrjG8iZAoMeSrGmB5hBzKu8rswto2iIYFjfBTik5BNaA2VNnLVEuEU7_omxC6Oy7RhPp6JejbFdoIqHOauD5V1RsX37_b5kGGGV72GxZotkR1WtzTTAj4o1-1K-1jwKkixZiC99BPlN4XIApjJjo-oMgVPY1ull_YJv2a2BjnwboKAAKkOeA_iS0QYTqNBXb4KCnKuE4tKBIN1FM0f8o8dT1ljRTMw1ZTrJSy5b3y8sSK11-TTyo8GnkI_2U6pihVG2CzqJDQqfZvZ4l0e-Qr-1hZoew3iylZneVmovIzXIdgUFByP8e2VRN4PbjoEldYHmSiUzPcR4o6OBkhRhmztHVAgOh4Dbtqg8cvslaxfOaiUs3z8jh1vZ7yzr-G_vCtiCB0xvXBzYtdjt-v_hvwabSAdoVH91xQqnf-4WFTsTz9QsMOh5J5mNvDIn1oCHR-_Q9dCf6YHVtTOtpUnewqnUjab7fJxT2BG9lleNcf3GGEP6PdLqwksNb4tAG9Rvm2i71LFzaUdFoaCz_fDDxhHdGVD-jkP9S1UGZ8G90yRXlz-0Ate--eqgM7TSRp15UHistyyekIfWvlchU")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Api::class.java)
    }
}