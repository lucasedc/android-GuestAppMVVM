package com.example.guestapp.ui.all

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guestapp.model.GuestModel
import com.example.guestapp.repository.GuestRepository
import com.example.guestapp.utils.DataBaseConstants

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)
    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: String) {
        when (filter){
            DataBaseConstants.FILTER.FILTER_ALL ->
                mGuestList.value = mGuestRepository.getAll()
            DataBaseConstants.FILTER.FILTER_ABSENTS ->
                mGuestList.value = mGuestRepository.getAbsents()
            DataBaseConstants.FILTER.FILTER_PRESENTS ->
                mGuestList.value = mGuestRepository.getPresents()
            else ->mGuestList.value = mGuestRepository.getAll()
        }

    }

}