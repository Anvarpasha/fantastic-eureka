package com.anvarpasha.avtogarage.ui.orderDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anvarpasha.avtogarage.data.network.model.response.SingleOrderResponse
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.persistence.prefs
import com.anvarpasha.avtogarage.data.network.repository.ProjectRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OrderDetailVM(val repository: ProjectRepository) : ViewModel() {

    private val _properties = MutableLiveData<SingleOrderResponse>()
    val properties : LiveData<SingleOrderResponse>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    fun getSingleOrder(id:String) {

        coroutineScope.launch {


            when (val response  = repository.getSingleOrder(prefs.getShopId(),id)) {
                is APIResponse.Success -> {
                    _properties.value = response.body
                }
                is APIResponse.Error -> {
                    Log.e("error", "${response.message} ${response.code}")
                }
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}