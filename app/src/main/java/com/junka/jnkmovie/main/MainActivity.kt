package com.junka.jnkmovie.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.junka.jnkmovie.R
import com.junka.jnkmovie.databinding.ActivityMainBinding
import com.junka.jnkmovie.main.base.BaseActivity
import com.junka.jnkmovie.main.communication.CommunicationCallback
import com.junka.jnkmovie.main.communication.MainAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(), CommunicationCallback {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var navController: NavController

    val currentNavigationFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.childFragmentManager
            ?.fragments
            ?.first()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)

    }

    override fun onFragmentEvent(action: MainAction) {

    }
}