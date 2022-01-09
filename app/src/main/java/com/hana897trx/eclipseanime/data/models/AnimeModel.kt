package com.hana897trx.eclipseanime.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimeModel(
    var _id : String? = "",
    var animeName : String? = "",
    var animeTypeId : Int? = 0,
    var coverUrl : String? = "",
    var splashArtUrl : String? = "",
    var animeDescription : String? = "",
    var alternaTitle : String? = "",
    var publishDate : String? = "",
    var status : String? = "",
    var likes : Int? = 0,
    var creators : String? = ""
) : Parcelable