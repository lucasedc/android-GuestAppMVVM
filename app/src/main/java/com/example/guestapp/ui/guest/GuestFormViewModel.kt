package com.example.guestapp.ui.guest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guestapp.model.GuestModel
import com.example.guestapp.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext

    private var mGuestRepository = GuestRepository.getInstance(mContext)


    private var mSaveGuest = MutableLiveData<Boolean>()
    var saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(guestModel: GuestModel) {
        mGuestRepository.save(guestModel)
    }


}