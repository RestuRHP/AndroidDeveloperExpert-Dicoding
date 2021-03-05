package net.pradana.core.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import net.pradana.core.data.database.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): DiscoveryMovieDao
}