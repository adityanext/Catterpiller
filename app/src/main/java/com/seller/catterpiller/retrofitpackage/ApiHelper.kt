package com.seller.catterpiller.retrofitpackage

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()
    suspend fun addnewUsers() = apiService.addnewUsers()
}