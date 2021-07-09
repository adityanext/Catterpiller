package com.seller.catterpiller.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.seller.catterpiller.repositories.UserRepository
import com.seller.catterpiller.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthViewModel( private val repository: UserRepository):ViewModel() {
    var url:String?=null
    var authListener:AuthListener?=null


    suspend fun userSignup(urlrequest: String) = withContext(Dispatchers.IO) {
        repository.addnewuser(urlrequest) 
    }

//    fun OnAddAccountButtonClick(view:View) {
//         authListener?.onStarted()
//         if (url.isNullOrEmpty()) {
//             authListener?.onFailure("Invalid message response")
//             return
//         }
//         Coroutines.main {
//         val response = UserRepository().addnewuser(urlrequest)
//             if (response.isSuccessful){
//                 authListener?.onSuccess("User Entry done")
//
//             }
//             else{
//                 authListener?.onFailure("User Entry failed")
//
//             }
//     }
//    }










    //    fun getLoggedInUser() = repository.getUser()

//    suspend fun userLogin(
//        email: String,
//        password: String
//    ) = withContext(Dispatchers.IO) { repository.userLogin(email, password) }


//    suspend fun saveLoggedInUser(user: User) = repository.saveUser(user)



}