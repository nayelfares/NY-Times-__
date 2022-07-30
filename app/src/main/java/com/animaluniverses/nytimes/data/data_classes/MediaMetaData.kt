package com.animaluniverses.nytimes.data.data_classes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaMetaData(
    var metaDataId: Int?,
    var url: String?,
    var format : String?
):Parcelable