package com.junka.jnkmovie.main.communication

interface CommunicationCallback {
    fun onFragmentEvent(action: MainAction)
}