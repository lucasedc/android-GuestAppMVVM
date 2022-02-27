package com.example.guestapp.ui.guest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.guestapp.R
import kotlinx.android.synthetic.main.activity_guest_form.*


class GuestFormActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        setListener()
    }

    private fun setListener() {
        button_guest_form_save.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        var id = view.id
        if(id == R.id.button_guest_form_save){
            saveGuest()
        }
    }

    private fun saveGuest() {
        TODO("Not yet implemented")
    }
}