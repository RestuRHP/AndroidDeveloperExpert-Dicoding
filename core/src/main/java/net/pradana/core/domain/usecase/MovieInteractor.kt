package net.pradana.core.domain.usecase

import net.pradana.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getDiscoveryMovie() = movieRepository.getDiscoveryMovie()
}