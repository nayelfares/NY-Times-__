package com.animaluniverses.nytimes

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

class DataBindingHelper {
    companion object {
        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun loadImage(view: ImageView, url: String) {
            val circularProgressDrawable = CircularProgressDrawable(view.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()
            Glide.with(view.context)
                .load(url)
                .placeholder(circularProgressDrawable)
                .error(R.mipmap.error)
                .into(view)
        }

    }
}