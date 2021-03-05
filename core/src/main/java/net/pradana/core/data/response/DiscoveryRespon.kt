package net.pradana.core.data.response


import com.google.gson.annotations.SerializedName

data class DiscoveryResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("total_pages")
    var totalPages: Int,
    @SerializedName("results")
    var results: List<MovieResponse>
)