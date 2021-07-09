package com.seller.catterpiller.configutils

import android.R.attr
import android.app.ProgressDialog
import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.TimeUnit
import java.util.regex.Matcher
import java.util.regex.Pattern

object Validations {
    var progress: ProgressDialog? = null


     fun isValidConfirmPassword(password: String?,confirmpassword: String?,context: Context?): Boolean {
        if (!password.equals(confirmpassword, ignoreCase = true)
        ) {
            ShowToast(
                context,
                "Confirm password must be match"
            )
            return false
        }
        return true
    }

    fun hideProgress() {
        if (progress != null && progress!!.isShowing) {
            progress!!.dismiss()
        }
    }


    var MobilePattern = "[0-9]{10}"

    fun isValidEmail(email: String?,context: Context?): Boolean {
        if (!email.equals("")
        ) {
            ShowToast(
                context,
                "Enter email field"
            )
            return false
        }
        return true


//        val EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
//        val pattern = Pattern.compile(EMAIL_PATTERN)
//        val matcher = pattern.matcher(email)
//        return matcher.matches()
    }

    fun ShowToast(context: Context?, Message: String?) {
        val toast = Toast.makeText(context, Message, Toast.LENGTH_SHORT)
        toast.show()
    }



    fun ShowSnack(relativeLayout: RelativeLayout?, Message: String?) {
        Snackbar.make(relativeLayout!!, Message!!, Snackbar.LENGTH_LONG).show()
    }


    fun CountDownTimer(Time: String, textView: TextView) {
        try {
            val FlashCount = Time.toInt()
            val FlashMiliSec = FlashCount * 1000.toLong()
            object : CountDownTimer(FlashMiliSec, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val Days = TimeUnit.HOURS.toDays(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                    )
                    val Hours =
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished) - TimeUnit.DAYS.toHours(
                            TimeUnit.MILLISECONDS.toDays(millisUntilFinished)
                        )
                    val Minutes =
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                        )
                    val Seconds =
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                        )
                    val format = "%1$02d"
                    textView.text = String.format(
                        format,
                        Days
                    ) + ":" + String.format(format, Hours) + ":" + String.format(
                        format,
                        Minutes
                    ) + ":" + String.format(format, Seconds)
                }

                override fun onFinish() {
                    textView.text = "Entry Over!"
                }
            }.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


     fun isValidPassword(password: String?): Boolean {
         val pattern: Pattern
         val matcher: Matcher

         val PASSWORD_PATTERN =
             "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$"

         pattern = Pattern.compile(PASSWORD_PATTERN)
         matcher = pattern.matcher(password)
         Log.e("password",matcher.matches().toString())

//         return matcher.matches()
//        val pattern: Pattern
//        val matcher: Matcher
//        val PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)$"
//        pattern = Pattern.compile(PASSWORD_REGEX)
//        matcher = pattern.matcher(password)
//
         return matcher.matches()
    }
//    fun isValidPassword(password: String?): Boolean {
//        val pattern: Pattern
//        val matcher: Matcher
//        val PASSWORD_PATTERN = Pattern.compile("^(?=.*[@$%&#_()=+?»«<>£§€{}\\[\\]-])(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).*(?<=.{4,})$")
//
////        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[A-Z])(?=\\S+$).{4,}$"
////        pattern = Pattern.compile(PASSWORD_PATTERN)
////        matcher = pattern.matcher(password)
//        return PASSWORD_PATTERN.matcher(password).matches()
//    }
}
