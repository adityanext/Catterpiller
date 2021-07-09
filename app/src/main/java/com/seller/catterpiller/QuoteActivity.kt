package com.seller.catterpiller

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class QuoteActivity : AppCompatActivity(), ClickDashboardAdapter{
    var context: Context? = null
    var recyclerView: RecyclerView? = null
    var dashboardAdapter: DashboardAdapter? = null
    private val dashboardModelArrayList: ArrayList<DashboardModel>? = null

    lateinit var mainViewModel: MainViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        context=this
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuote())
        setAdapter()
    }

    private fun setAdapter() {
//        recyclerView?.visibility=View.VISIBLE
//        dashboardAdapter = DashboardAdapter(context, dashboardModelArrayList, this)
//        recyclerView?.adapter=dashboardAdapter
    }

    fun setQuote(quote: Quote){
        quoteText.text = quote.textname
        quoteAuthor.text = quote.author
    }

    fun onPrevious(view: View) {
        setQuote(mainViewModel.previousQuote())
    }

    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuote())
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().textname)
        startActivity(intent)
    }

    override fun clickoncard(view: ImageView?, position: Int) {
        TODO("Not yet implemented")
    }


}