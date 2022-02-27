package com.example.guestapp.repository

import android.content.ContentValues
import android.content.Context
import com.example.guestapp.database.GuestDataBaseHelper
import com.example.guestapp.model.GuestModel
import com.example.guestapp.utils.DataBaseConstants
import java.lang.Exception
import java.util.ArrayList

class GuestRepository private constructor(context: Context) {


    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }


    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsents(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun delete(guestModel: GuestModel) {

    }

    fun update(guestModel: GuestModel) {

    }

    fun save(guestModel: GuestModel): Boolean {
        try {
            var db = mGuestDataBaseHelper.writableDatabase

            val contentValue = ContentValues()
            contentValue.put(DataBaseConstants.GUEST.COLUMNS.NAME, guestModel.name)
            contentValue.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guestModel.presence)
            db.insert(DataBaseConstants.GUEST.TABLE_NAME,null,contentValue)
            return true
        }catch (e: Exception){
            return false
        }


    }
}