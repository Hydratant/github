package com.tami.github.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tami.github.domain.GetUsersByQueryUseCase
import com.tami.github.domain.Result
import com.tami.github.entity.UserItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersByQueryUseCase: GetUsersByQueryUseCase
) : ViewModel() {


    val query = mutableStateOf("")

    private val _users = MutableLiveData<List<UserItemEntity>>()
    val users: LiveData<List<UserItemEntity>> get() = _users


    fun getUsersByQuery(query: String) {
        viewModelScope.launch {
            val params = GetUsersByQueryUseCase.Param(query)
            val result = getUsersByQueryUseCase(params)
            when (result) {
                is Result.Error -> {}
                Result.Loading -> {}
                is Result.Success -> _users.value = result.data
            }
        }
    }
}