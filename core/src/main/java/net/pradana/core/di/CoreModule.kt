package net.pradana.core.di

import androidx.room.Room
import net.pradana.core.BuildConfig
import net.pradana.core.data.database.room.MovieDatabase
import net.pradana.core.data.datastore.discoveryStore.MovieLocalStore
import net.pradana.core.data.datastore.discoveryStore.MovieRemoteStore
import net.pradana.core.data.network.Api
import net.pradana.core.domain.repository.IMovieRepository
import net.pradana.core.domain.repository.MovieRepository
import net.pradana.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(Api::class.java)
    }
}

val repositoryModule = module {
    single { MovieRemoteStore(get()) }
    single { MovieLocalStore(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> {
        MovieRepository(
            get(),
            get(),
            get()
        )
    }
}

val databaseModule = module {
    factory { get<MovieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, "movie.db"
        ).fallbackToDestructiveMigration().build()
    }
}