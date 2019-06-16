package com.lucas.mandiocadafazenda.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.mandiocadafazenda.R
import com.lucas.mandiocadafazenda.model.DeliveryModelTest
import kotlinx.android.synthetic.main.layout_deliveries.view.*

class DeliveryAdapter (
    val myData: List<DeliveryModelTest>,
    val mContext: Context
): RecyclerView.Adapter<DeliveryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_deliveries, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = myData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = myData[position]
        holder.name.text = item.name
        holder.qtd.text = item.qtd
        holder.desc.text = item.product
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.tv_localName
        val qtd = itemView.tv_productQtdD
        val desc = itemView.tv_productDesc
    }
}