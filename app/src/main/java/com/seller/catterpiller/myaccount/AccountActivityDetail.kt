package com.seller.catterpiller.myaccount

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

class AccountActivityDetail : AppCompatActivity(), ClickAccountAdapter {
    lateinit var context: Context
    var recyclerView: RecyclerView? = null
    lateinit var accountdetailmodel:AccountActivityDetailModel
    lateinit var accountAdapter: AccountDetailAdapter
    private  lateinit var  accountModelArraylist: ArrayList<AccountActivityDetailModel>

    val date_body = arrayOf("01/06/21","10/06/21","20/06/21","30/06/21","10/06/21","10/06/21","10/06/21","10/06/21","10/06/21","10/06/21")
    val time_body = arrayOf("10:20 AM","10:21 AM","10:22 AM","10:23 AM","10:23 AM","10:23 AM","10:23 AM","10:23 AM","10:23 AM","10:23 AM")
    val duration_body = arrayOf("0:10 min","0:20 min","0:30 min","0:40 min","0:40 min","0:40 min","0:40 min","0:40 min","0:40 min","0:40 min")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myaccountdetail)
        context=this
        recyclerView=findViewById(R.id.recyclerview)
        recyclerView?.layoutManager = GridLayoutManager(this,1)
        setAdapter()
    }

    private fun setAdapter() {
        accountModelArraylist= ArrayList()
        for (i in 0..9) {
            accountdetailmodel= AccountActivityDetailModel()
            Log.e("adaptersize",date_body[i]);
            accountdetailmodel.setDate(date_body[i])
            accountdetailmodel.setTime(time_body[i])
            accountdetailmodel.setDuration(duration_body[i])
            accountModelArraylist.add(accountdetailmodel)
        }
        accountAdapter = AccountDetailAdapter(context, accountModelArraylist, this)
        recyclerView?.adapter=accountAdapter
    }





    override fun clickoncard(view: ImageView?, position: Int) {
//        TODO("Not yet implemented")
    }

    fun OnLogouttButton(view: View) {
        finish()

    }

    fun backbtncancel(view: View) {
        finish()

    }


}