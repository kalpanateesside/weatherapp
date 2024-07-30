package uk.ac.tees.mad.w9641722.weatherapp.api

import uk.ac.tees.mad.w9641722.weatherapp.domain.model.WeatherResponse
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.forecast_model.ForecastResponse
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.search_model.ResponseSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("v1/current.json")
    suspend fun getCurrentWeather(
        @Query("q")
        location: String,
        @Query("key")
        key: String = "e666878d058642c2bd153213243007"
    ): Response<WeatherResponse>


    @GET("v1/search.json")
    suspend fun searchWeather(
        @Query("q")
        searchQuery: String,
        @Query("key")
        key: String = "e666878d058642c2bd153213243007"
    ): Response<ResponseSearch>

    @GET("v1/forecast.json")
    suspend fun getForecast(
        @Query("q")
        location: String,
        @Query("days")
        days: Int = 5,
        @Query("key")
        key: String = "e666878d058642c2bd153213243007"
    ): Response<ForecastResponse>
}