package org.d3if1102.noteq.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if1102.noteq.model.Motivasi
import org.d3if1102.noteq.network.ApiStatus
import org.d3if1102.noteq.network.MotivateApi

class MainViewModel : ViewModel() {
    private val data = MutableLiveData<List<Motivasi>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(MotivateApi.service.getMotivate())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Motivasi>> = data
    fun getStatus(): LiveData<ApiStatus> = status
}