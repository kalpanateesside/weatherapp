package uk.ac.tees.mad.w9641722.weatherapp.model

data class WeatherResponse(
    val current: Current,
    val location: Location,
    val condition: Condition
)