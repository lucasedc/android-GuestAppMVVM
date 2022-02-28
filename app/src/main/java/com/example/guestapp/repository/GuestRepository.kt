package com.example.guestapp.repository

import android.content.ContentValues
import android.content.Context
import com.example.guestapp.database.GuestDataBaseHelper
import com.example.guestapp.model.GuestModel
import com.example.guestapp.ui.guest.GuestFormViewModel
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

    fun getById(id: Int): GuestModel {

        var guest: GuestModel = null
        try {
            var db = mGuestDataBaseHelper.readableDatabase

            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )


            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME,
                projection,
                selection,
                args, null, null, null
            )

            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()
                val name = cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME).toInt())
                val presence = (cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE).toInt()).toInt()==1)
                guest = GuestModel(id,name,presence)
            }
            cursor.close()


            return guest
        } catch (e: Exception) {
            return guest
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

    fun delete(id: Int): Boolean {
        try {
            var db = mGuestDataBaseHelper.writableDatabase

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())
            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)

            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun update(guestModel: GuestModel): Boolean {
        try {
            var db = mGuestDataBaseHelper.writableDatabase

            val contentValue = ContentValues()
            contentValue.put(DataBaseConstants.GUEST.COLUMNS.NAME, guestModel.name)
            contentValue.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guestModel.presence)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guestModel.id.toString())
            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValue, selection, args)

            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun save(guestModel: GuestModel): Boolean {
        try {
            var db = mGuestDataBaseHelper.writableDatabase

            val contentValue = ContentValues()
            contentValue.put(DataBaseConstants.GUEST.COLUMNS.NAME, guestModel.name)
            contentValue.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guestModel.presence)
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValue)
            return true
        } catch (e: Exception) {
            return false
        }


    }
}