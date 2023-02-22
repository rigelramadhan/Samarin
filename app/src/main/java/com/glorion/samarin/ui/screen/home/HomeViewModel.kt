package com.glorion.samarin.ui.screen.home

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
class HomeViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow<Resource<List<User>>>(Resource.Loading())
    val uiState: StateFlow<Resource<List<User>>> get() = _uiState

    init {
        loadData(results)
    }

    private fun loadData(results: Int) {
        viewModelScope.launch {
            userUseCase.getRandomUsers(results)
                .catch {

                }
                .collect { data ->
                    _uiState.value = data
                }
        }
    }

    companion object {
        private var results = 20
    }
}