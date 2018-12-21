package com.example.dom.ydayssocialcup.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.example.dom.ydayssocialcup.interfaces.OnItemAdapterClickListener
import com.example.dom.ydayssocialcup.model.UserList
import kotlinx.android.synthetic.main.user_list_item.view.*

class UserListAdapter(val items : ArrayList<UserList>, val context: Context, clickListener : OnItemAdapterClickListener) : RecyclerView.Adapter<ViewHolder>() {

    private var onItemClickListener: OnItemAdapterClickListener?

    init {
        onItemClickListener = clickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false),onItemClickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewUserSection?.text = items.get(position).sectionName
        holder.imageViewUserSection?.setImageResource(items.get(position).iconSection)
    }

}

class ViewHolder (itemView: View,  onItemClickListener: OnItemAdapterClickListener?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    private val onItemClickListener: OnItemAdapterClickListener? = onItemClickListener

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        onItemClickListener?.onItemAdapterClick(adapterPosition)
    }

    // Holds the TextView that will add each animal to
    val textViewUserSection = itemView.textView_user_section
    val imageViewUserSection = itemView.imageView_user_section
}
