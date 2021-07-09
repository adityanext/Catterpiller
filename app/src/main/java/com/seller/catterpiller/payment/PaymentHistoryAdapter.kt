package com.seller.catterpiller.payment

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
import com.seller.catterpiller.myaccount.AccountActivityDetailModel
import com.seller.catterpiller.myaccount.AccountDetailAdapter
import com.seller.catterpiller.myaccount.ClickAccountAdapter
import java.util.*
private var selectedPosition: Int = 0

class PaymentHistoryAdapter(

    private val mcontext: Context, private val paymentModelArraylist: ArrayList<PaymentHistorylModel>, var clickAdapter: ClickPaymentHistoryAdapter
) : RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.accountdetailadapter_layout, null, false)
        view.layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val listModel = paymentModelArraylist[position]
        var title_Des: String? = listModel.date
        var title_time: String? = listModel.time
        var title_duration: String? = listModel.duration

        viewHolder.text_date.text = title_Des.toString()
        viewHolder.text_time.text = title_time.toString()
        viewHolder.text_duration.text = title_duration.toString()



    }

    override fun getItemCount(): Int {
        return paymentModelArraylist.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var text_date: TextView
        var text_time: TextView
        var text_duration: TextView

        init {
            text_date = itemView.findViewById(R.id.text_date)
            text_time = itemView.findViewById(R.id.text_time)
            text_duration = itemView.findViewById(R.id.text_duration)
        }
    }

}