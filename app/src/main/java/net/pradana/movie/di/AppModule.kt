package net.pradana.movie.di

import net.pradana.core.domain.usecase.MovieInteractor
import net.pradana.core.domain.usecase.MovieUseCase
import net.pradana.movie.ui.movie.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module{
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
}