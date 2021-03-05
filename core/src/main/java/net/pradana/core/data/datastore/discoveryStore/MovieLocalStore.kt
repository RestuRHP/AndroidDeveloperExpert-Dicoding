package net.pradana.core.data.datastore.discoveryStore

import kotlinx.coroutines.flow.Flow
import net.pradana.core.data.database.entity.MovieEntity
import net.pradana.core.data.database.room.DiscoveryMovieDao

class MovieLocalStore(private val movieDao: DiscoveryMovieDao) {
    fun getAllDiscoveryMovie():Flow<List<MovieEntity>> = movieDao.getAllDiscoveryMovie()

    suspend fun insertDiscoveryMovie(movieList: List<MovieEntity>) = movieDao.insertDiscoveryMovie(movieList)
}