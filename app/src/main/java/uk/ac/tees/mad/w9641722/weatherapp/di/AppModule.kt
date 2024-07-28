package uk.ac.tees.mad.w9641722.weatherapp.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import uk.ac.tees.mad.w9641722.weatherapp.api.RetrofitInstance
import uk.ac.tees.mad.w9641722.weatherapp.api.WeatherAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uk.ac.tees.mad.w9641722.weatherapp.repository.AuthRepositoryImpl
import uk.ac.tees.mad.w9641722.weatherapp.domain.repository.AuthRepository
import uk.ac.tees.mad.w9641722.weatherapp.repository.WeatherRepository

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl(
        auth = Firebase.auth
    )

    @Provides
    fun providesAPI(): WeatherAPI {
        return RetrofitInstance.api
    }

    @Provides
    fun providesRepository(): WeatherRepository{
        return WeatherRepository()
    }
}