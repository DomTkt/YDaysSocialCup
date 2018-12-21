package com.example.dom.ydayssocialcup.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.example.dom.ydayssocialcup.interfaces.OnItemAdapterClickListener
import com.example.dom.ydayssocialcup.model.MessageCommunity
import kotlinx.android.synthetic.main.cell_row_list_community.view.*


class MessageCommunityAdapter(val items : ArrayList<MessageCommunity>, val context: Context) : RecyclerView.Adapter<ViewHolderMessage>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMessage {
        return ViewHolderMessage(LayoutInflater.from(context).inflate(R.layout.cell_row_list_community, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolderMessage, position: Int) {
        holder.textViewComment?.text = items.get(position).comment
        holder.imageIconCommunityUser?.setImageResource(items.get(position).iconMessageUser)
    }

}

class ViewHolderMessage (itemView: View) : RecyclerView.ViewHolder(itemView) {

    // Holds the TextView that will add each animal to
    val textViewComment = itemView.textViewRowCommunity
    val imageIconCommunityUser = itemView.imageViewRowCommunity
}
