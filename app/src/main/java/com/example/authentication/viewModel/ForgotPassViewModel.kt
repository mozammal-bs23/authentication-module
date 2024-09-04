package com.example.authentication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authentication.data.forgotPassword.ForgotPassResModel
import com.example.authentication.model.ForgotPassModel
import com.example.authentication.model.ForgotPassResult
import com.example.authentication.model.OTPValidationModel
import com.example.authentication.model.OTPValidationResult
import com.example.authentication.services.network.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ForgotPassViewModel @Inject constructor(
    private val forgotPassModel: ForgotPassModel,
    private val otpValidationModel: OTPValidationModel
) : ViewModel() {


    // Email for password reset
    private var correctEmail: String = ""

    /// LiveData for forgot password state
    private val _forgotPassState = MutableLiveData<ForgotPassResult? >()
    val forgotPassState: MutableLiveData<ForgotPassResult?> = _forgotPassState


    /// LiveData for error state
    private  val _errorState = MutableLiveData<String?>()
    val errorState: LiveData<String?> = _errorState


    fun forgotPassword(email: String) {
        viewModelScope.launch {
            when (val result = forgotPassModel.forgotPassword(email)) {
                is ForgotPassResult.Success -> {
                    _forgotPassState.value = result
                    _errorState.value = null

                    correctEmail = email;


                    Timber.i("Login successful: ${result.response.message}")
                }
                is ForgotPassResult.Error -> {
                    _errorState.value = result.errorModel.message
                    Timber.e("Login failed: ${result.errorModel.message}")
                }
            }
        }
    }

    fun resetForgotPassState() {
        _forgotPassState.value = null
    }

    private  val _otpValidationState = MutableLiveData<OTPValidationResult?>()
    val otpValidationState: LiveData<OTPValidationResult?> get() = _otpValidationState



    fun validateOTP(otp: String){
        Timber.i("email is $correctEmail and otp is $otp");

        viewModelScope.launch {
            when (val result = otpValidationModel.validateOTP(correctEmail, otp)) {

                is OTPValidationResult.Success -> {
                    _otpValidationState.value = result
                    _errorState.value = null  // Clear any previous errors
                    Timber.i("Login successful: ${result.response.message}")
                }
                is OTPValidationResult.Error -> {
                    _errorState.value = result.error.message
                    Timber.e("Login failed: ${result.error.message}")
                }
            }
        }
    }

    fun resetOTPValidationState() {
        _otpValidationState.value = null
    }


}