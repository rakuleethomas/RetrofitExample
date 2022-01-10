package org.rakulee.retrofitexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    private val _data : MutableLiveData<ArrayList<ExchangeResult.ExchangeItem>> by lazy {
        MutableLiveData<ArrayList<ExchangeResult.ExchangeItem>>()
    }
    val data : MutableLiveData<ArrayList<ExchangeResult.ExchangeItem>> get() = _data

    fun updateData(list : ArrayList<ExchangeResult.ExchangeItem>){
        _data.postValue(list)
    }
}