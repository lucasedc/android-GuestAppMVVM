package com.example.guestapp.repository

import com.example.guestapp.model.GuestModel
import java.util.ArrayList

class GuestRepository {

    fun getAll(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresents(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsents(): List<GuestModel>{
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun delete(guestModel: GuestModel){

    }
    fun update(guestModel: GuestModel){

    }

    fun save(guestModel: GuestModel){

    }
}