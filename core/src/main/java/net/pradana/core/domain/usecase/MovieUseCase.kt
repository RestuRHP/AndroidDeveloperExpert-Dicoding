package net.pradana.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import net.pradana.core.data.Resource
import net.pradana.core.domain.model.Movie

interface MovieUseCase {
    fun getDiscoveryMovie(): Flow<Resource<List<Movie>>>
}