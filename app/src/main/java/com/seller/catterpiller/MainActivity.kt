package com.seller.catterpiller

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.seller.catterpiller.loginmodule.LoginActivity
import com.seller.catterpiller.signupmodule.SignUpActivity
import java.util.*

class MainActivity : AppCompatActivity(), ClickDashboardAdapter{
    var context: Context? = null
    var recyclerView: RecyclerView? = null
    var dashboardAdapter: DashboardAdapter? = null
    private val dashboardModelArrayList: ArrayList<DashboardModel>? = null

    lateinit var mainViewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context=this
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark

//        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
//        setQuote(mainViewModel.getQuote())
//        setAdapter()
    }

    private fun setAdapter() {
//        recyclerView?.visibility=View.VISIBLE
//        dashboardAdapter = DashboardAdapter(context, dashboardModelArrayList, this)
//        recyclerView?.adapter=dashboardAdapter
    }


    override fun clickoncard(view: ImageView?, position: Int) {
        TODO("Not yet implemented")
    }

    fun OnSignUpButton(view: View) {
        val intent = Intent(context, SignUpActivity::class.java)
        startActivity(intent)
    }

    fun OnLoginButton(view: View) {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }

    fun termscondition(view: View) {}
    fun troublelogin(view: View) {}


}