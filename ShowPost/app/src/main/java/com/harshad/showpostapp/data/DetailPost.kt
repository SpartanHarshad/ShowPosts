package com.harshad.showpostapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailPost(
    var userId: Int? = null,
    var id: Int? = null,
    var title: String = "",
    var body: String = ""
) : Parcelable