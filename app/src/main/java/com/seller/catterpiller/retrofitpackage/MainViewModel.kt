package com.seller.catterpiller.retrofitpackage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class MainViewModel (private val mainRepository: MainRepository) : ViewModel() {


    //showusers
    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


//    //showusers
//    suspend fun getUsers() = coroutineScope {
//        val deffered =async(Dispatchers.IO){
//
//        }
//        deffered.await()
//    }

    //addnewusers
    fun addnewUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.addnewUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}