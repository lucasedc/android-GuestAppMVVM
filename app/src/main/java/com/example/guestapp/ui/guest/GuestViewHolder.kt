package com.example.guestapp.ui.guest

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guestapp.R
import com.example.guestapp.listener.GuestListener
import com.example.guestapp.model.GuestModel

class GuestViewHolder(itemView: View, var listener: GuestListener) : RecyclerView.ViewHolder(itemView) {
    fun bind(guest: GuestModel){
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name

        textName.setOnClickListener{
            listener.onClick(guest.id)
        }

    }
}