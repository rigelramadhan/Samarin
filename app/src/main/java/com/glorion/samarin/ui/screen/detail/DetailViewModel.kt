package com.glorion.samarin.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glorion.samarin.core.data.Resource
import com.glorion.samarin.core.domain.model.User
import com.glorion.samarin.core.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Resource<User>>(Resource.Loading())

    val uiState: StateFlow<Resource<User>> get() = _uiState

    private fun loadData(id: String) {
        viewModelScope.launch {
            userUseCase.getUserById(id)
                .catch {  }
                .collect {
                    _uiState.value = it
                }
        }
    }
}