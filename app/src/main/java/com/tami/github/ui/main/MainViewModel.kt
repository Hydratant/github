package com.tami.github.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tami.github.domain.GetUsersByQueryUseCase
import com.tami.github.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersByQueryUseCase: GetUsersByQueryUseCase
) : ViewModel() {

    fun getUsersByQuery(query: String) {
        viewModelScope.launch {
            val params = GetUsersByQueryUseCase.Param(query)
            val result = getUsersByQueryUseCase(params)
            when (result) {
                is Result.Error -> {}
                Result.Loading -> {}
                is Result.Success -> {}
            }
        }
    }
}