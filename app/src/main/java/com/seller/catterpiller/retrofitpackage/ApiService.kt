package com.seller.catterpiller.retrofitpackage

import com.seller.catterpiller.loginmodule.LoginModel
import com.seller.catterpiller.loginmodule.LoginDataSet
import com.seller.catterpiller.signupmodule.Signupdatset
import retrofit2.http.GET

 interface  ApiService {

    @GET("users")
    suspend fun getUsers(): List<LoginDataSet>

    @GET("?apikey=K9sDPPql0ycwudWsw6ZJKfYdsDpyVyyS&action=pbxware.ext.add&server=5&name=Anesaapiext&email=test@test.com&location=2&ua=50&status=1&pin=1234&incominglimit=2&outgoinglimit=2&voicema il=1&prot=sip&secret=123456789 ")
    suspend fun addnewUsers(): String
}