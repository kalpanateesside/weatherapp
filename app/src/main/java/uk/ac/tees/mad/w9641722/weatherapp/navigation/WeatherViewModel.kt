package uk.ac.tees.mad.w9641722.weatherapp.navigation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import retrofit2.Response
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.WeatherResponse
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.forecast_model.ForecastResponse
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.search_model.ResponseSearchItem
import uk.ac.tees.mad.w9641722.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel(){

    private val _searchText = MutableStateFlow("New castle")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _city = MutableStateFlow(listOf<ResponseSearchItem>())
    val city = searchText
        .combine(_city){ text, city ->
            if(text.isBlank()){
                city
            }else{
                city.filter { it.name.contains(text, ignoreCase = true) }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _city.value
        )

    fun setSearchText(query: String) {
        _searchText.value = query
    }

    fun performSearch() {
        viewModelScope.launch {
            val searchText = _searchText.value
            _isSearching.value = true
            try {
                val results = repository.searchWeather(searchText)// Replace with your repository method
                _city.value = results.body()!!
            } catch (e: Exception) {
                // Handle error
                Log.i("My Error", e.toString())
            } finally {
                _isSearching.value = false
            }
        }
    }

    fun getCurrentWeather(city: String): Flow<Response<WeatherResponse>> = flow {
        val currentWeather = repository.getCurrentWeather(city)
        emit(currentWeather)
    }

    fun getForecast(location: String): Flow<Response<ForecastResponse>> = flow {
        val forecast = repository.getForecast(location)
        emit(forecast)
    }

}