package uk.ac.tees.w9633914.weatherman.model.forecast_model

data class ForecastResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)