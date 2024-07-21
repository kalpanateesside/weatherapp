package uk.ac.tees.w9633914.weatherman.repository

import uk.ac.tees.w9633914.weatherman.api.RetrofitInstance

class WeatherRepository{
    suspend fun getCurrentWeather(location: String) =
        RetrofitInstance.api.getCurrentWeather(location)

    suspend fun searchWeather(searchQuery: String) =
        RetrofitInstance.api.searchWeather(searchQuery)

    suspend fun getForecast(location: String) =
        RetrofitInstance.api.getForecast(location)
}