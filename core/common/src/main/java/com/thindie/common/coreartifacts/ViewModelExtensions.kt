package com.thindie.common.coreartifacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

fun <T : ViewState, R, H> R.requestResultAndParse(
    request: suspend () -> Result<H>,
    onSuccess: (H) -> Unit,
) where R : ViewStateHolder<T>, R : ViewModel {
    onLoading()
    viewModelScope.launch {
        val result = request.invoke()
        result
            .onSuccess { _ ->
                onSuccess(result.getOrThrow())
            }
            .onFailure {
                onError()
            }
    }
}


fun <T : ViewState, R, H> R.requestFlowResultAndParse(
    request: () -> Flow<Result<H>>,
    onSuccess: (H) -> Unit,
) where R : ViewStateHolder<T>, R : ViewModel {
    onLoading()
    viewModelScope.launch {
        val result = request.invoke()
        result
            .onEach { someResult ->
                someResult
                    .onSuccess { _ ->
                        onSuccess(someResult.getOrThrow())
                    }
                    .onFailure {
                        onError()
                    }
            }.launchIn(this)
    }
}