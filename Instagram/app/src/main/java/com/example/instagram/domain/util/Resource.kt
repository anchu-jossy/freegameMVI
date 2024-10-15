package com.example.instagram.domain.util


sealed class Resource<T>(val data: T? =null, val message: String?=null,isLoading :Boolean?=null){
    class  Sucess<T>(data:T) :Resource<T>(data )
    class Error<T>(data:T?=null,error: String) : Resource<T>(data,error)
    class Loading<T>(data: T?=null,isLoading: Boolean?):Resource<T>(data, isLoading = isLoading)

}
