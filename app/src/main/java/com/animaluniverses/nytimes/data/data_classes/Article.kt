package com.animaluniverses.nytimes.data.data_classes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    var articleId: Long?,
    var uri: String?,
    var url: String?,
    var source: String?,
    var published_date: String?,
    var section: String?,
    var subsection: String?,
    var byline: String?,
    var title: String?,
    var description: String?,
    var media: List<Media>?= null
): Parcelable