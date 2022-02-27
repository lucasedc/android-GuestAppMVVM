package com.example.guestapp.repository

import android.content.Context
import com.example.guestapp.database.GuestDataBaseHelper
import com.example.guestapp.model.GuestModel
import java.util.ArrayList

class GuestRepository private constructor(context: Context){


    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object{
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository{
            if(!::repository.isInitialized){
                repository = GuestRepository(context)
            }
            return repository
        }
    }




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