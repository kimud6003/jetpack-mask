package com.example.jetpack_mask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_mask.model.Store
import com.example.jetpack_mask.repository.MaskService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MainViewModel: ViewModel() {

    val itemLiveData = MutableLiveData<List<Store>>()
    val loadingLiveData = MutableLiveData<Boolean>()

    private val service: MaskService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(MaskService.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        service = retrofit.create(MaskService::class.java)
        fetchStoreInfo()
    }

    fun fetchStoreInfo(){
       loadingLiveData.value = true
        viewModelScope.launch {
           val storeInfo = service.fetchStoreInfo(37.188078,127.043002)
            itemLiveData.value = storeInfo.stores
            loadingLiveData.value = false
        }
    }
}