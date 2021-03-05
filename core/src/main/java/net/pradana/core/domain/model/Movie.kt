package net.pradana.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var movieId: Int,
    var backdropPath: String,
    var id: Int,
    var originalLanguage: String,
    var originalTitle: String,
    var overview: String,
    var posterPath: String,
    var releaseDate: String,
    var voteAverage: Double,
    var isFavorite: Boolean = false
) : Parcelable
