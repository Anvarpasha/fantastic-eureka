package com.anvarpasha.avtogarage.data.network.repository

import android.widget.TextView
import com.anvarpasha.avtogarage.data.network.model.request.ForgotModel
import com.anvarpasha.avtogarage.data.network.model.request.LoginModel
import com.anvarpasha.avtogarage.data.network.model.request.OtpModel
import com.anvarpasha.avtogarage.data.network.model.response.*
import com.anvarpasha.avtogarage.data.network.network.APIResponse
import com.anvarpasha.avtogarage.data.network.network.ProjectApi
import retrofit2.http.QueryMap

class ProjectRepository(private val apiService : ProjectApi) {

    suspend fun loginUser(loginModel: LoginModel): APIResponse<LoginResponse?>{
        val apiResponse = apiService.loginAsync(loginModel).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
         }
    }


  suspend fun sendOtp(model: OtpModel): APIResponse<OtpMainResponse?>{
        val apiResponse = apiService.sendOtp(model).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
         }
    }


  suspend fun recoverPassword(model: ForgotModel): APIResponse<ForgotResponse?>{
        val apiResponse = apiService.recoverPassword(model).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
         }
    }


  suspend fun getOrders(shopId:String): APIResponse<OrderResponse?>{
        val apiResponse = apiService.getOrders(shopId).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
         }
    }


  suspend fun getSingleOrder(shopId:String,orderId:String): APIResponse<SingleOrderResponse?>{
        val apiResponse = apiService.getSingleOrder(shopId,orderId).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
         }
    }


   suspend fun getProfile() : APIResponse<ProfileResponse?>{
        val apiResponse = apiService.getProfile().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
        }
    }


    suspend fun getSearchScreen(@QueryMap query: TextView, value2: TextView) : APIResponse<SearchResponse?>{
        val apiResponse = apiService.getSearchScreenAsync(query,value2).await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
        }
    }


    suspend fun logOut() : APIResponse<LogOutResponse?>{
        val apiResponse = apiService.logout().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
        }
    }


    suspend fun putChange() : APIResponse<ChangeResponse?>{
        val apiResponse = apiService.putChange().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
        }
    }

    suspend fun getAccept() : APIResponse<AcceptResponse?>{
        val apiResponse = apiService.getAccept().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
        }
    }


    suspend fun getCancel() : APIResponse<CancelResponse?>{
        val apiResponse = apiService.getCancel().await()
        return if (apiResponse.isSuccessful)
            APIResponse.Success(apiResponse.body())
        else{
            APIResponse.Error(apiResponse.message(),apiResponse.code())
        }
    }










}