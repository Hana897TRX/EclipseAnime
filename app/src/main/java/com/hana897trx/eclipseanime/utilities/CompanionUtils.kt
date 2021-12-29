package com.hana897trx.eclipseanime.utilities

import android.annotation.SuppressLint
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

object DataUtils {
    const val ANIME_CODE = "EXTRA:ANIME_MODEL"
}

object GlideUtils {
    @SuppressLint("StaticFieldLeak")
    var glide : RequestManager? = null

    fun getInstance(context : Context) : RequestManager {
        return if(glide == null) {
            glide = Glide.with(context)
            glide!!
        } else {
            glide!!
        }
    }
}