package net.pradana.core.utils

import net.pradana.core.data.database.entity.MovieEntity
import net.pradana.core.data.response.MovieResponse
import net.pradana.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>):List<MovieEntity>{
        val movieList = ArrayList<MovieEntity>()
        input.map{
            var movies = MovieEntity(
                movieId = it.movieId,
                backdropPath = it.backdropPath,
                id = it.id,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                isFavorite = it.isFavorite
            )
            movieList.add(movies)
        }
        return movieList
    }

    fun mapEntityToDomain(input: List<MovieEntity>):List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                backdropPath = it.backdropPath,
                id = it.id,
                originalLanguage = it.originalLanguage,
                originalTitle = it.originalTitle,
                overview = it.overview,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                isFavorite = it.isFavorite
            )
        }
}