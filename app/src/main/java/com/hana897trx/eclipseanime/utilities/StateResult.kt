package com.hana897trx.eclipseanime.utilities

sealed class StateResult<out T : Any?> {
    data class Success<out T : Any?>(val data : T) : StateResult<T>()
    data class Error(val errorCode: Int = 0, val errorMessage : String = "") : StateResult<Nothing>()
    data class Loading(val isLoading : Boolean) : StateResult<Nothing>()
}