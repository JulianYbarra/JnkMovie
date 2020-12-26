package com.junka.jnkmovie.main.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.junka.jnkmovie.main.MainActivity
import com.junka.jnkmovie.main.communication.CommunicationCallback

abstract class BaseFragment : Fragment() {

    lateinit var communication: CommunicationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communication = (requireActivity() as MainActivity)
    }

}