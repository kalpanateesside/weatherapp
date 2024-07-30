package uk.ac.tees.mad.w9641722.weatherapp.domain.model.forecast_model

data class ForecastResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)