package com.junka.jnkmovie.core

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun ImageView.loadTMDB(lastPath : String) {
    Glide
        .with(this)
        .load( "$BASE_IMAGE_URL$lastPath")
        .into(this)
}