package com.seller.catterpiller.retrofitpackage

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
    suspend fun addnewUsers() = apiHelper.addnewUsers()
}