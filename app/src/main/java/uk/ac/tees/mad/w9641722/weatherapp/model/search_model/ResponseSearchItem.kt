package uk.ac.tees.w9633914.weatherman.model.search_model

data class ResponseSearchItem(
    val country: String,
    val id: Int,
    val lat: Double,
    val lon: Double,
    val name: String,
    val region: String,
    val url: String
)