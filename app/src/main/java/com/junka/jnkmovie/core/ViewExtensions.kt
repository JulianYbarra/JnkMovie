package com.junka.jnkmovie.core

import android.view.View

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun View.showOrHide(visibility : Boolean){
    if(visibility) show() else hide()
}

