package net.pradana.core.domain.repository

import kotlinx.coroutines.flow.Flow
import net.pradana.core.data.Resource
import net.pradana.core.domain.model.Movie

interface IMovieRepository {
    fun getDiscoveryMovie(): Flow<Resource<List<Movie>>>
}