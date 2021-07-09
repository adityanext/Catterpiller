package com.seller.catterpiller.mybalance

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
import java.util.*
import kotlin.collections.ArrayList

class BalanceActivity : AppCompatActivity(), ClickBalanceAdapter {
    lateinit var context: Context
    var recyclerView: RecyclerView? = null
    lateinit var balancemodel:BalanceModel
    lateinit var balanceAdapter: BalanceAdapter
    private  lateinit var  balanceModelArraylist: ArrayList<BalanceModel>

    val text_body = arrayOf(10,15,20,30)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mybalance)
        context=this
        recyclerView=findViewById(R.id.recyclerview)
        recyclerView?.layoutManager = GridLayoutManager(this,4)
        setAdapter()
    }

    private fun setAdapter() {
        balanceModelArraylist= ArrayList()
        for (i in 0..3) {
            balancemodel= BalanceModel()
            Log.e("adaptersize",text_body[i].toString());
            balancemodel.setTitle_amount(text_body[i])
//            balancemodel.setImage_Ar(imagearr[i])
            balanceModelArraylist.add(balancemodel)
        }
        balanceAdapter = BalanceAdapter(context, balanceModelArraylist, this)
        recyclerView?.adapter=balanceAdapter
    }





    override fun clickoncard(view: ImageView?, position: Int) {
//        TODO("Not yet implemented")
    }

    fun OnLogoutButton(view: View) {
        finish()

    }

    fun OnSendtButton(view: View) {}
    fun backbtncancel(view: View) {
        finish()

    }


}