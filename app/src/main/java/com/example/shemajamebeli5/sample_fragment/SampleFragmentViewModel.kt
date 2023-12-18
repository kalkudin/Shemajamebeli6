package com.example.shemajamebeli5.sample_fragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebeli5.client.ApiClient
import com.example.shemajamebeli5.model.ApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SampleFragmentViewModel : ViewModel() {
    private val _apiResponse = MutableStateFlow<ApiResponse?>(null)
    val apiResponse: StateFlow<ApiResponse?> get() = _apiResponse

    fun fetchData() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getUsers()
                _apiResponse.value = response
                Log.d("SampleFragmentViewModel", "Data loaded successfully: $response")
            } catch (e: Exception) {
                Log.e("SampleFragmentViewModel", "Error loading data: ${e.message}", e)
            }
        }
    }
}