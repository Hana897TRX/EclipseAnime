package com.hana897trx.eclipseanime.utilities

sealed class StateResult<out T : Any?> {
    data class Success<out T : Any?>(val data : T) : StateResult<T>()
    data class Error(val messageCode: Int, val errorCode : Int = 0) : StateResult<Nothing>()
    data class Loading(val isLoading : Boolean) : StateResult<Nothing>()
}