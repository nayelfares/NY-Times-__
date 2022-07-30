package com.animaluniverses.nytimes

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageUrl(imageUrl: String?) {
    Glide.with(context)
        .load(imageUrl)
        .into(this)
}