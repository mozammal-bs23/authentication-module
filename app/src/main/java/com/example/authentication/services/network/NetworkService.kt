package com.example.authentication.services.network

import com.example.authentication.model.data.forgotPassword.ForgotPassReqModel
import com.example.authentication.model.data.forgotPassword.ForgotPassResModel
import com.example.authentication.model.data.login.LoginRequestModel
import com.example.authentication.model.data.login.LoginResponseModel
import com.example.authentication.model.data.otpValidation.OTPValidationReqModel
import com.example.authentication.model.data.otpValidation.OTPValidationResModel
import com.example.authentication.model.data.setNewPass.SetNewPassReqModel
import com.example.authentication.model.data.setNewPass.SetNewPassResModel
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkService {
    @POST("login")
    suspend fun login(@Body request: LoginRequestModel): LoginResponseModel

    @POST("forget-password")
    suspend fun forgotPassword(@Body request: ForgotPassReqModel): ForgotPassResModel

    @POST("verifyOtp")
    suspend fun otpValidation(@Body request: OTPValidationReqModel): OTPValidationResModel

    @POST("set-new-password")
    suspend fun setNewPass(@Body request: SetNewPassReqModel): SetNewPassResModel
}