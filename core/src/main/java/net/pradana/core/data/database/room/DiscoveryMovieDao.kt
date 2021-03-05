package net.pradana.core.data.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import net.pradana.core.data.database.entity.MovieEntity

@Dao
interface DiscoveryMovieDao {

    @Query("SELECT * FROM movie")
    fun getAllDiscoveryMovie():Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiscoveryMovie(tourism: List<MovieEntity>)

}