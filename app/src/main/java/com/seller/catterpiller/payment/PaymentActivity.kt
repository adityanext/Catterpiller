package com.seller.catterpiller.payment

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

class PaymentActivity : AppCompatActivity(), ClickPaymentAdapter {
    lateinit var context: Context
    var recyclerView: RecyclerView? = null
    lateinit var paymentmodel:PaymentModel
    lateinit var paymentAdapter: PaymentAdapter
    private  lateinit var  paymentModelArraylist: ArrayList<PaymentModel>

    val text_body = arrayOf(20,30,40)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paymentbalance)
        context=this
        recyclerView=findViewById(R.id.recyclerview)
        recyclerView?.layoutManager = GridLayoutManager(this,3)
        setAdapter()
    }

    private fun setAdapter() {
        paymentModelArraylist= ArrayList()
        for (i in 0..2) {
            paymentmodel= PaymentModel()
            Log.e("adaptersize",text_body[i].toString());
            paymentmodel.setTitle_amount(text_body[i])
//            balancemodel.setImage_Ar(imagearr[i])
            paymentModelArraylist.add(paymentmodel)
        }
        paymentAdapter = PaymentAdapter(context, paymentModelArraylist, this)
        recyclerView?.adapter=paymentAdapter
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

    fun OnCancelButtin(view: View) {
        finish()

    }


}