package com.hana897trx.eclipseanime.utilities

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

object DataUtils {
    const val ANIME_CODE = "EXTRA:ANIME_MODEL"
    const val ANIME_ID = "EXTRA:ANIME_ID"
}

object APIData {
    const val URLBase = "http://192.168.1.79:3000"
    const val APIBase = "/api/v1/"
}

object GlideUtils {
    @SuppressLint("StaticFieldLeak")
    private var glide : RequestManager? = null

    fun getInstance(context : Context) : RequestManager {
        return if(glide == null) {
            glide = Glide.with(context)
            glide!!
        } else {
            glide!!
        }
    }
}

fun makeToast(text : String, context: Context) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}