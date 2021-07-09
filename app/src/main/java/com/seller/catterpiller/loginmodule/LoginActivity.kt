package com.seller.catterpiller.loginmodule

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.seller.catterpiller.DashBoardActivity
import com.seller.catterpiller.R
import com.seller.catterpiller.configutils.Validations
import com.seller.catterpiller.resetpassword.ResetPasswordActivity
import com.seller.catterpiller.signupmodule.SignUpActivity

class LoginActivity: AppCompatActivity() {
    var context: Context? = null
    var ed_username: EditText? = null
    var username: String? = null
    var ed_password: EditText? = null
    var password: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        context=this
        ed_username=findViewById(R.id.ed_username)
        ed_password=findViewById(R.id.ed_password)

    }

    fun OnLoginButton(view: View) {
        username = ed_username?.text.toString()
        password = ed_password?.text.toString()
        when {
            username == "" -> {
                Validations.ShowToast(
                    context,
                    "Enter username"
                )
            }
            password == "" -> {
                Validations.ShowToast(
                    context,
                    "Enter Password"
                )
            }
            username== "Test" && password== "test@123"->{
                val intent = Intent(context, DashBoardActivity::class.java)
                startActivity(intent)
            }
            else -> {
                Validations.ShowToast(
                    context,
                    "Enter valid credentials for username and password"
                )
                val intent = Intent(context, DashBoardActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun troublelogin(view: View) {
        val intent = Intent(context, ResetPasswordActivity::class.java)
        startActivity(intent)
//        val alert = ViewDialog()
//        alert.showDialog(this@LoginActivity, username)
    }

    fun textCancel(view: View) {
        finish()

    }

    fun OnSignUpButton(view: View) {
        val intent = Intent(context, SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }

}

// class ViewDialog {
//    fun showDialog(activity: Activity?, msg: String?) {
//        val dialog = Dialog(activity!!)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(false)
//        dialog.setContentView(R.layout.dialog)
//        val text = dialog.findViewById<EditText>(R.id.edttext_email)
//        val imagecancel =
//            dialog.findViewById<ImageView>(R.id.image_cancel)
//        imagecancel.setOnClickListener { dialog.dismiss() }
//        text.setText(msg)
//        val dialogButton =
//            dialog.findViewById<View>(R.id.btn_signin) as Button
//        dialogButton.setOnClickListener(View.OnClickListener {
//
//                                dialog.dismiss();
//        })
//        dialog.show()
//    }
//}
