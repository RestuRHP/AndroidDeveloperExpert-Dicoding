package net.pradana.core.data.datastore.discoveryStore

import kotlinx.coroutines.flow.Flow
import net.pradana.core.data.network.ApiResponse

interface BaseDiscoveryRemoteStore<T> {
    suspend fun getDiscoveryMovie(page:Int):Flow<ApiResponse<List<T>>>
}