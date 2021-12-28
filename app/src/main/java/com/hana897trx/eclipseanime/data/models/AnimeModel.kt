package com.hana897trx.eclipseanime.data.models

import com.google.gson.annotations.JsonAdapter

data class AnimeModel(
    var animeName : String?,
    var animeTypeId : Int?,
    var coverUrl : String?,
    var splashArtUrl : String?,
    var animeDescription : String?,
    var alternaTitle : String?,
    var publishDate : String?,
    var status : String?,
    var likes : Int?,
    var creators : String?
)