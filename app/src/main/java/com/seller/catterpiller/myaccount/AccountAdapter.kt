package com.seller.catterpiller.myaccount

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seller.catterpiller.R
import java.util.*
private var selectedPosition: Int = 0

class AccountAdapter(

     private val mcontext: Context, private val accountModeArrayList: ArrayList<AccountModel>, var clickAdapter: ClickAccountAdapter) : RecyclerView.Adapter<AccountAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.accountadapter_layout, null, false)
        view.layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val listModel = accountModeArrayList[position]
        var title_Des: String? = listModel.getTitle()

        viewHolder.text_body.text = title_Des.toString()


        viewHolder.rootlayout.setOnClickListener(View.OnClickListener {

            clickAdapter.clickoncard(null, position)

        })

    }

    override fun getItemCount(): Int {
        return accountModeArrayList.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var rootlayout: RelativeLayout
        var text_body: TextView

        init {
            text_body = itemView.findViewById(R.id.text_body)
            rootlayout = itemView.findViewById(R.id.rootlayout)
        }
    }

}