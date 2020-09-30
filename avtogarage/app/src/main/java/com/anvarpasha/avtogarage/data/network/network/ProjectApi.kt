package com.anvarpasha.avtogarage.data.network.network

import android.widget.TextView
import com.anvarpasha.avtogarage.data.network.model.request.ForgotModel
import com.anvarpasha.avtogarage.data.network.model.request.OtpModel
import com.anvarpasha.avtogarage.data.network.model.request.LoginModel
import com.anvarpasha.avtogarage.data.network.model.response.*
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*


 interface  ProjectApi {

    @POST ("login")
    fun loginAsync(@Body user : LoginModel) : Deferred<Response<LoginResponse>>

    @POST ("sendOtp")
    fun sendOtp(@Body user : OtpModel) : Deferred<Response<OtpMainResponse>>


    @POST ("recoverPassword")
    fun recoverPassword(@Body model : ForgotModel) : Deferred<Response<ForgotResponse>>


    @GET("shops/{shopId}/reports/")
    fun getOrders(@Path("shopId")shopId:String) : Deferred<Response<OrderResponse>>


    @GET("shops/{shopId}/reports/{orderId}")
    fun getSingleOrder(@Path("shopId")shopId:String,@Path("orderId")orderId:String) : Deferred<Response<SingleOrderResponse>>


    @GET("me")
    fun getProfile() : Deferred<Response<ProfileResponse>>


    @GET("shops/0/reports/")
    fun getSearchScreenAsync(@QueryMap query: TextView, value2: TextView) : Deferred<Response<SearchResponse>>

    @GET("logout")
    fun logout() : Deferred<Response<LogOutResponse>>

    @PUT("update")
    fun putChange() : Deferred<Response<ChangeResponse>>

    @GET("sendAcceptMessages")
    fun getAccept() : Deferred<Response<AcceptResponse>>

    @GET("sendCancelMessages")
    fun getCancel() : Deferred<Response<CancelResponse>>


 }