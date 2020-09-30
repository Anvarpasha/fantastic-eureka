package com.anvarpasha.avtogarage.data.network.model.response

import android.os.Parcelable
import com.anvarpasha.avtogarage.data.network.model.remote.Accept
import com.anvarpasha.avtogarage.data.network.model.remote.Cancel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class CancelResponse (
    @SerializedName("message")
    val message : String,
    @SerializedName("data")
    val list : List<Cancel>
) : Parcelable