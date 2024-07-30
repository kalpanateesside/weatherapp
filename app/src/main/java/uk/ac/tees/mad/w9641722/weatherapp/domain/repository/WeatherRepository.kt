package uk.ac.tees.mad.w9641722.weatherapp.domain.repository

import uk.ac.tees.mad.w9641722.weatherapp.api.RetrofitImpl

class WeatherRepository{
    suspend fun getCurrentWeather(location: String) =
        RetrofitImpl.api.getCurrentWeather(location)

    suspend fun searchWeather(searchQuery: String) =
        RetrofitImpl.api.searchWeather(searchQuery)

    suspend fun getForecast(location: String) =
        RetrofitImpl.api.getForecast(location)
}