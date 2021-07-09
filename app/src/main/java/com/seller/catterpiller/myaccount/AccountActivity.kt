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
import com.seller.FaqActivity
import com.seller.catterpiller.ClickDashboardAdapter
import com.seller.catterpiller.R
import com.seller.catterpiller.configutils.Cons
import com.seller.catterpiller.loginmodule.LoginActivity
import com.seller.catterpiller.mybalance.BalanceActivity
import com.seller.catterpiller.payment.PaymentHistoryActivity
import java.util.*
import kotlin.collections.ArrayList

class AccountActivity : AppCompatActivity(), ClickAccountAdapter {
    lateinit var context: Context
    var recyclerView: RecyclerView? = null
    lateinit var accountmodel:AccountModel
    lateinit var accountAdapter: AccountAdapter
    private  lateinit var  accountModelArraylist: ArrayList<AccountModel>

    val text_body = arrayOf("Account Activity","Payment History","FAQ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myaccount)
        context=this
        recyclerView=findViewById(R.id.recyclerview)
        recyclerView?.layoutManager = GridLayoutManager(this,1)
        setAdapter()
    }

    private fun setAdapter() {
        accountModelArraylist= ArrayList()
        for (i in 0..2) {
            accountmodel= AccountModel()
            Log.e("adaptersize",text_body[i]);
            accountmodel.setTitle(text_body[i])
            accountModelArraylist.add(accountmodel)
        }
        accountAdapter = AccountAdapter(context, accountModelArraylist, this)
        recyclerView?.adapter=accountAdapter
    }





    override fun clickoncard(view: ImageView?, position: Int) {
        Log.e("pos",position.toString())
        when (position) {

            0 -> setupintent(AccountActivityDetail::class.java)
            1 -> setupintentpayment(PaymentHistoryActivity::class.java)
            2 -> setupintentFaq(FaqActivity::class.java)


        }
    }

    private fun setupintentFaq(java: Class<FaqActivity>) {
        val intent = Intent(context, java)
        intent.putExtra("Heading", "TERMS AND CONDITION")
        intent.putExtra("URL", Cons.ABOUTUSURL)
        startActivity(intent)

    }

    private fun setupintentpayment(java: Class<PaymentHistoryActivity>) {
        val intent = Intent(context, java)
        startActivity(intent)

    }
//        TODO("Not yet implemented")    }

        private fun setupintent(java: Class<AccountActivityDetail>) {
            val intent = Intent(context, java)
            startActivity(intent)
        }

    fun OnLogouttButton(view: View) {
        finish()
    }

    fun backbtncancel(view: View) {
        finish()

    }

    fun OnLogoutButton(view: View) {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }


}