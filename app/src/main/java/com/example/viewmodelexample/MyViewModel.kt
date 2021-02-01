package com.example.viewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val numero = MutableLiveData<Int>()

    init{
        numero.value = 0
    }

    fun getData(): LiveData<Int> {
        return numero
    }

    fun addNumero(n:Int){
        var count:Int = numero.value!!
        numero.value = count + n
    }
}