package net.pradana.movie.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import net.pradana.core.domain.usecase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movies = movieUseCase.getDiscoveryMovie().asLiveData()
}