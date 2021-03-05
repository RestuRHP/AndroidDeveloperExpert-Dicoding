package net.pradana.core.data.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
        @PrimaryKey(autoGenerate = true)
        var movieId:Int,
        var backdropPath: String,
        var id: Int,
        var originalLanguage: String,
        var originalTitle: String,
        var overview: String,
        var posterPath: String,
        var releaseDate: String,
        var voteAverage: Double,
        var isFavorite:Boolean = false
)