package com.animaluniverses.nytimes.base

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.animaluniverses.nytimes.R
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.HttpException

open class BaseViewModel : ViewModel(), KoinComponent {
    val mContext: Context by inject()
    val handleError = MutableLiveData<String>()
    fun <T> launch(apiMethod: suspend () ->T,
                   onComplete: ((result: T) -> Unit)? = null,
                   onError: ((error: Exception) -> Unit)? = null) {
        viewModelScope.launch {
            try {
                val response = apiMethod.invoke()
                onComplete?.invoke(response)
            } catch (ex: Exception) {
                onError?.invoke(ex)
                handleError(ex)
            }
        }
    }

    private fun handleError(e: Throwable): String {
        if (e is HttpException) {
            val error = e.response()!!.errorBody()!!.string()

        }
        handleError.value = mContext.getString(R.string.api_default_error)
        return mContext.getString(R.string.api_default_error)
    }
}