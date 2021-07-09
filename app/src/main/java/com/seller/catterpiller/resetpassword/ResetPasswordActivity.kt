package com.seller.catterpiller.resetpassword

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.seller.catterpiller.R
import com.seller.catterpiller.loginmodule.LoginActivity
import com.seller.catterpiller.signupmodule.SignUpActivity
import java.util.*

class ResetPasswordActivity : AppCompatActivity(){
    var context: Context? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog)
        context=this

    }

    fun textCancel(view: View) {
        finish()
    }


}