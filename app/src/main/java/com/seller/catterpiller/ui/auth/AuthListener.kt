package com.seller.catterpiller.ui.auth

import retrofit2.Response

interface AuthListener {
    fun onStarted()
    fun onCreated()
    fun onFinished()
    fun onSuccess(response: String)
    fun onFailure(response: String)
}