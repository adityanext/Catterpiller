package com.seller.catterpiller

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seller.catterpiller.myaccount.AccountActivity
import com.seller.catterpiller.myaccount.AccountActivityDetail
import com.seller.catterpiller.mybalance.BalanceActivity
import com.seller.catterpiller.payment.PaymentActivity
import kotlin.collections.ArrayList

class DashBoardActivity : AppCompatActivity(), ClickDashboardAdapter{
    public lateinit var context: Context
    var recyclerView: RecyclerView? = null
    lateinit var dashboardModel:DashboardModel
    lateinit var dashboardAdapter: DashboardAdapter
    private  lateinit var  dashboardModelArrayList: ArrayList<DashboardModel>
    val imagearr = intArrayOf(R.drawable.ic_services, R.drawable.ic_payment, R.drawable.ic_account,R.drawable.ic_balance)
    val text_body = arrayOf("","","","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        context=this
        recyclerView=findViewById(R.id.recyclerview)
        recyclerView?.layoutManager = GridLayoutManager(this,2)
        setAdapter()
    }

    private fun setAdapter() {
        dashboardModelArrayList= ArrayList()
        for (i in 0..3) {
            dashboardModel= DashboardModel()
            Log.e("adaptersize",text_body[i]);
            dashboardModel.setTitle_description(text_body[i])
            dashboardModel.setImage_Ar(imagearr[i])
            dashboardModelArrayList.add(dashboardModel)
        }
        dashboardAdapter = DashboardAdapter(context, dashboardModelArrayList, this)
        recyclerView?.adapter=dashboardAdapter
    }

    override fun clickoncard(view: ImageView?, position: Int) {
        when(position){
            0->setupintentServicesActivity(ServicesActivity::class.java)
            1->setupintentPaymentActivity(PaymentActivity::class.java)
            2->setupintentAccountActivityDetail(AccountActivity::class.java)
            3->setupintent(BalanceActivity::class.java)
        }
//        TODO("Not yet implemented")
    }

    fun OnLogoutButton(view: View) {
        finish()

    }

    private fun setupintent(java: Class<BalanceActivity>) {
        val intent = Intent(context, java)
        startActivity(intent)
    }
    private fun setupintentAccountActivityDetail(java: Class<AccountActivity>) {
        val intent = Intent(context, java)
        startActivity(intent)
    }
    private fun setupintentPaymentActivity(java: Class<PaymentActivity>) {
        val intent = Intent(context, java)
        startActivity(intent)
    }
    private fun setupintentServicesActivity(java: Class<ServicesActivity>) {
        val intent = Intent(context, java)
        startActivity(intent)
    }



}