package com.hana897trx.eclipseanime.data.models

import com.squareup.moshi.Json

data class RemoteResponse<T>(
    @field:Json(name = "data") var data: T?,
    @field:Json(name = "code") var code: Int,
    @field:Json(name = "message") var message: String?
    )