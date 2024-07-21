package uk.ac.tees.w9633914.weatherman.model

data class WeatherResponse(
    val current: Current,
    val location: Location,
    val condition: Condition
)