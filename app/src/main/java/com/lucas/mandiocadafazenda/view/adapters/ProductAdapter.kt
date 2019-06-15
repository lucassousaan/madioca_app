package com.lucas.mandiocadafazenda.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.mandiocadafazenda.R
import com.lucas.mandiocadafazenda.model.ProductModelTest
import kotlinx.android.synthetic.main.layout_products.view.*

class ProductAdapter (
    val myData: List<ProductModelTest>,
    val mContext: Context
): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_products, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = myData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = myData[position]
        holder.name.text = item.name
        holder.qtd.text = item.qtd
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.tv_productName
        val qtd = itemView.tv_productQtd
    }

}