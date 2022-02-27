package com.example.guestapp.ui.guest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guestapp.model.GuestModel
import com.example.guestapp.repository.GuestRepository

class GuestFormViewModel : ViewModel() {

    private var mGuestRepository = GuestRepository()


    private var mSaveGuest = MutableLiveData<Boolean>()
    var saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(guestModel: GuestModel) {
        mGuestRepository.save(guestModel)
    }


}