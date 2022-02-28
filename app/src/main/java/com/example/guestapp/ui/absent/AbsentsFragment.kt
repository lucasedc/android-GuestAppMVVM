package com.example.guestapp.ui.absent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guestapp.R
import com.example.guestapp.databinding.FragmentAbsentBinding
import com.example.guestapp.listener.GuestListener
import com.example.guestapp.ui.all.GuestsViewModel
import com.example.guestapp.ui.guest.GuestAdapter
import com.example.guestapp.ui.guest.GuestFormActivity
import com.example.guestapp.utils.DataBaseConstants
import com.example.guestapp.utils.GuestConstants

class AbsentsFragment : Fragment() {

    private var _binding: FragmentAbsentBinding? = null
    private lateinit var guestViewModel: GuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mGuestListener: GuestListener
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        guestViewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)

        _binding = FragmentAbsentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_absent_guests)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        guestViewModel.load(DataBaseConstants.FILTER.FILTER_ABSENTS)

        mGuestListener = object : GuestListener {
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUESTID,id)
                intent.putExtras(bundle)
                startActivity(intent,)
            }

        }
        mAdapter.attachListener(mGuestListener)

        observe()

        return root
    }

    private fun observe() {
        guestViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuest(it)

        })
    }

    override fun onResume() {
        super.onResume()
        guestViewModel.load(DataBaseConstants.FILTER.FILTER_ABSENTS)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}