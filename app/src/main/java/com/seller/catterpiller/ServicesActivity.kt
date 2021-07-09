package com.seller.catterpiller

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seller.catterpiller.ClickDashboardAdapter
import com.seller.catterpiller.R
import com.seller.catterpiller.mybalance.BalanceActivity
import java.util.*
import kotlin.collections.ArrayList

class ServicesActivity : AppCompatActivity() {
    lateinit var context: Context
    var recyclerView: RecyclerView? = null


    val text_body = arrayOf("Account Activity","Payment History","Settings")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)
        context=this

    }

    fun textCancel(view: View) {
        finish()

    }


}