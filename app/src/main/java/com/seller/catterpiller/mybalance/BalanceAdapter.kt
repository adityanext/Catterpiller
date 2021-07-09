package com.seller.catterpiller.mybalance

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seller.catterpiller.R
import java.util.*
private var selectedPosition: Int = 0

class BalanceAdapter(

     private val mcontext: Context, private val balanceModeArrayList: ArrayList<BalanceModel>, var clickAdapter: ClickBalanceAdapter) : RecyclerView.Adapter<BalanceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.balance_layout, null, false)
        view.layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val listModel = balanceModeArrayList[position]
        var title_Des: Int? = listModel.getTitle_amount()

        viewHolder.text_body.text = title_Des.toString()


        viewHolder.rootlayout.setOnClickListener(View.OnClickListener {

            selectedPosition = position
            notifyDataSetChanged()
        })

        if (selectedPosition == position) {
            viewHolder.text_body.setBackgroundColor(Color.parseColor("#000000"))
            viewHolder.text_body.setTextColor(Color.parseColor("#ffffff"));

        } else {
            viewHolder.text_body.setBackgroundDrawable(mcontext.getDrawable(R.drawable.balancebg_layout))
            viewHolder.text_body.setTextColor(Color.parseColor("#000000"));
        }
    }

    override fun getItemCount(): Int {
        return balanceModeArrayList.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var rootlayout: LinearLayout
        var text_body: TextView

        init {
            text_body = itemView.findViewById(R.id.text_body)
            rootlayout = itemView.findViewById(R.id.rootlayout)
        }
    }

}