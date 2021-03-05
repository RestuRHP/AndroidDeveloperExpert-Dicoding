package net.pradana.core.data.datastore.discoveryStore

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import net.pradana.core.data.network.Api
import net.pradana.core.data.network.ApiResponse
import net.pradana.core.data.response.MovieResponse

class MovieRemoteStore(private val api: Api) : BaseDiscoveryRemoteStore<MovieResponse> {
    override suspend fun getDiscoveryMovie(page: Int): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = api.getDiscoveryMovie(1)
                val listMovie = response.results
                if(listMovie.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                    Log.d("List Movie", response.results.toString())
                }else{
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("MovieRemoteStore",e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}