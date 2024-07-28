package uk.ac.tees.mad.w9641722.weatherapp.model

data class Location(
    val country: String?,
    val lat: Double?,
    val localtime: String?,
    val localtime_epoch: Int?,
    val lon: Double?,
    val name: String?,
    val region: String?,
    val tz_id: String?
)