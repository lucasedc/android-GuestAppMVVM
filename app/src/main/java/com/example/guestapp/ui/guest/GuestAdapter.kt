package com.example.guestapp.ui.guest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guestapp.R
import com.example.guestapp.listener.GuestListener
import com.example.guestapp.model.GuestModel

class GuestAdapter: RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList:List<GuestModel> = arrayListOf()
    private lateinit var mGuestListener: GuestListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
       val item = LayoutInflater.from(parent.context).inflate(R.layout.row_guest,parent,false)
        return GuestViewHolder(item,mGuestListener)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    fun updateGuest(list: List<GuestModel>){
        mGuestList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: GuestListener){
        mGuestListener = listener
    }
}