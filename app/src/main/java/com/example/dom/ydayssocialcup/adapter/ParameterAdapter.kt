package com.example.dom.ydayssocialcup.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.example.dom.ydayssocialcup.model.ParameterRow
import com.example.dom.ydayssocialcup.model.UserList
import kotlinx.android.synthetic.main.row_list_parameter.view.*
import kotlinx.android.synthetic.main.user_list_item.view.*

class ParameterAdapter(val items : ArrayList<ParameterRow>, val context: Context) : RecyclerView.Adapter<ParameterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParameterViewHolder {
        return ParameterViewHolder(LayoutInflater.from(context).inflate(R.layout.row_list_parameter, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ParameterViewHolder, position: Int) {
        holder.textViewUserSection?.text = items.get(position).sectionName
        holder.imageViewUserSection?.setImageResource(items.get(position).iconSection)
    }

}

class ParameterViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    // Holds the TextView that will add each animal to
    val textViewUserSection = itemView.textView_parameter_section
    val imageViewUserSection = itemView.imageView_parameter_section
}
