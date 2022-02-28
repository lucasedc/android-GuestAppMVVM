package com.example.guestapp.ui.guest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.guestapp.R
import com.example.guestapp.model.GuestModel
import com.example.guestapp.utils.GuestConstants
import kotlinx.android.synthetic.main.activity_guest_form.*


class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mGuestsViewModel : GuestFormViewModel
    private var mGuestId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)



        mGuestsViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListener()
        observe()
        loadData()

    }

    private fun loadData() {
        val data = intent.extras
        if(data != null){
            mGuestId = data.getInt(GuestConstants.GUESTID)
            mGuestsViewModel.load(mGuestId)
        }
    }

    private fun observe() {
        mGuestsViewModel.saveGuest.observe(this, Observer {
            if(it){
                Toast.makeText(applicationContext,"Sucesso!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Erro!", Toast.LENGTH_SHORT).show()
            }
            finish()
        })

        mGuestsViewModel.guestById.observe(this, Observer {
            edit_guest_form_name.setText(it.name)
            if(it.presence){
                radio_button_guest_form_present.isChecked = true
            }else{
                radio_button_guest_form_absent.isChecked = true
            }

        })
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
        val editName = edit_guest_form_name.text.toString()
        val presenceChoice = radio_button_guest_form_present.isChecked
        var guestModel = GuestModel(mGuestId, editName, presenceChoice)

        mGuestsViewModel.save(guestModel)
    }
}