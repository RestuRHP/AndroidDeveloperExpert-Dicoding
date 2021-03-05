package net.pradana.core.utils

import net.pradana.core.BuildConfig

object Network {
    const val GET_DISCOVERY_MOVIE = "discover/movie?api_key=${BuildConfig.API_KEY}&language=en-US&sort_by=vote_count.desc"
}