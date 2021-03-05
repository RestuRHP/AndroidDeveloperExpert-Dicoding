package net.pradana.core.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.pradana.core.data.NetworkBoundResource
import net.pradana.core.data.Resource
import net.pradana.core.data.datastore.discoveryStore.MovieLocalStore
import net.pradana.core.data.datastore.discoveryStore.MovieRemoteStore
import net.pradana.core.data.network.ApiResponse
import net.pradana.core.data.response.MovieResponse
import net.pradana.core.domain.model.Movie
import net.pradana.core.utils.AppExecutors
import net.pradana.core.utils.DataMapper

class MovieRepository(
    private val remoteStore: MovieRemoteStore,
    private val localStore: MovieLocalStore,
    private val appExecutors: AppExecutors
) : IMovieRepository {
    override fun getDiscoveryMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localStore.getAllDiscoveryMovie().map {
                    DataMapper.mapEntityToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteStore.getDiscoveryMovie(1)

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localStore.insertDiscoveryMovie(movieList)
            }
        }.asFlow()
}