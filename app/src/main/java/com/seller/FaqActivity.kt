package com.seller

import android.content.Context
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.seller.catterpiller.R

class FaqActivity:AppCompatActivity() {




    private var wv1: WebView? = null
    var activity: FaqActivity?= null
    var context: Context? = null
    var im_back: ImageView? = null
    var tv_HeaderName: TextView? = null
    var IntentHeading: String? = null
    var IntentURL:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqacitivity)
        activity = this
        context = activity
        IntentHeading = ""
        IntentURL = getIntent().getStringExtra("URL")
        initViews()
        LoadPage(IntentURL)

        tv_HeaderName?.setOnClickListener(View.OnClickListener {
            finish()
        })

    }

    fun initViews() {
        im_back = findViewById(R.id.image_backarrow)
        tv_HeaderName = findViewById(R.id.tv_HeaderName)
        wv1 = findViewById(R.id.webView1)
        tv_HeaderName!!.text = IntentHeading
        im_back!!.setOnClickListener { onBackPressed() }
    }

    fun LoadPage(Url: String?) {
        wv1!!.webViewClient = MyBrowser()
        wv1!!.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                if (progress == 100) {
                } else {
                }
            }
        }
        wv1!!.settings.loadsImagesAutomatically = true
        wv1!!.settings.javaScriptEnabled = true
        wv1!!.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        wv1!!.loadUrl(Url!!)
    }

    private class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    fun OnAccepttButton(view: View) {
        finish()
    }

}