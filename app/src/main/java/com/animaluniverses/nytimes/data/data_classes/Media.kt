package com.animaluniverses.nytimes.data.data_classes

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    val mediaId: Int?,
    val caption: String?,
    @SerializedName("media-metadata", alternate = ["metadata"]) val metadata: List<MediaMetaData>? = null
): Parcelable
