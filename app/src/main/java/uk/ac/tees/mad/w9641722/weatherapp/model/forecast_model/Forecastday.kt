package uk.ac.tees.w9633914.weatherman.model.forecast_model

import uk.ac.tees.w9633914.weatherman.model.forecast_model.Astro

data class Forecastday(
    val astro: Astro,
    val date: String,
    val date_epoch: Double,
    val day: Day,
    val hour: List<Hour>
)