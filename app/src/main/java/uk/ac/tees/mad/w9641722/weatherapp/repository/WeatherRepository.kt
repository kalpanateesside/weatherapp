package uk.ac.tees.mad.w9641722.weatherapp.repository

import uk.ac.tees.mad.w9641722.weatherapp.api.RetrofitInstance

class WeatherRepository{
    suspend fun getCurrentWeather(location: String) =
        RetrofitInstance.api.getCurrentWeather(location)

    suspend fun searchWeather(searchQuery: String) =
        RetrofitInstance.api.searchWeather(searchQuery)

    suspend fun getForecast(location: String) =
        RetrofitInstance.api.getForecast(location)
}