package com.seller.catterpiller.retrofitpackage

import com.seller.catterpiller.signupmodule.SignupStatus

data  class Resource <out T>(val status: SignupStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = SignupStatus.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = SignupStatus.ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status = SignupStatus.LOADING, data = data, message = null)
    }
}