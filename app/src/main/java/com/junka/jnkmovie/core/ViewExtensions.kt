package com.junka.jnkmovie.core

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun ImageView.loadTMDB(lastPath : String,size: String = PosterSize.ORIGINAL.value) {

    val path = "$BASE_IMAGE_URL/$size"

    Glide
        .with(this)
        .load( "$path$lastPath")
        .into(this)
}