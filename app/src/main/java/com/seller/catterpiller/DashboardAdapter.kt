package com.seller.catterpiller

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class DashboardAdapter(

            private val mcontext: Context, private val discoverArrayList: ArrayList<DashboardModel>, var clickAdapter: ClickDashboardAdapter) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
    var selectedPosition: Int = -1

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, null, false)
        view.layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val listModel = discoverArrayList[position]
        var title_Des: String? = listModel.getTitle_description()

        viewHolder.text_body.text = title_Des
        viewHolder.image_layout.setOnClickListener {
            clickAdapter.clickoncard(viewHolder.image, position)
            selectedPosition = position
            notifyDataSetChanged()
        }


        if (selectedPosition == position) {
            viewHolder.image_layout.setBackgroundColor(Color.parseColor("#567845"))
//            holder.text_title.setTextColor(Color.parseColor("#ffffff"));
        } else {
            viewHolder.image_layout.setBackgroundColor(Color.parseColor("#9177FF"))
//            holder.text_title.setTextColor(Color.parseColor("#000000"));
        }
         viewHolder.image.setImageResource(listModel.getImage_Ar());
    }

    override fun getItemCount(): Int {
        return discoverArrayList.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var text_layout: LinearLayout
        var image_layout: RelativeLayout
        var text_body: TextView
        var card_view: CardView

        init {
            text_body = itemView.findViewById(R.id.text_body)
            image = itemView.findViewById(R.id.image)
            text_layout = itemView.findViewById(R.id.text_layout)
            image_layout = itemView.findViewById(R.id.image_layout)
            card_view = itemView.findViewById(R.id.card_view)
        }
    }

}