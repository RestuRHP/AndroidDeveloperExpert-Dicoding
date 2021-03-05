package net.pradana.core.data.network

import net.pradana.core.data.response.DiscoveryResponse
import net.pradana.core.utils.Network.GET_DISCOVERY_MOVIE
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(GET_DISCOVERY_MOVIE)
    suspend fun getDiscoveryMovie(@Query("page") page: Int?): DiscoveryResponse
}