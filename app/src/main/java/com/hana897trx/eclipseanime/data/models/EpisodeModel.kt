package com.hana897trx.eclipseanime.data.models

data class EpisodeModel (
    var _id : String?,
    var animeName : String?,
    var animeId : String?,
    var lastUpdate : String?,
    var episodesLanguage : String?,
    var episodes : List<EpisodeDataModel>
    )