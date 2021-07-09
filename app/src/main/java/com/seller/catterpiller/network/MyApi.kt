package com.seller.catterpiller.network

import com.seller.catterpiller.network.response.AuthResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface MyApi {

    @GET
    suspend fun addUsersInfo(@Url url:String?): Response<AuthResponse>

    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("http://192.151.131.114/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }

}