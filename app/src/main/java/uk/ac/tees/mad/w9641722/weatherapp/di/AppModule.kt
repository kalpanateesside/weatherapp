package uk.ac.tees.w9633914.weatherman.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import uk.ac.tees.w9633914.weatherman.api.RetrofitInstance
import uk.ac.tees.w9633914.weatherman.api.WeatherAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uk.ac.tees.w9633914.weatherman.repository.AuthRepositoryImpl
import uk.ac.tees.w9633914.weatherman.domain.repository.AuthRepository
import uk.ac.tees.w9633914.weatherman.repository.WeatherRepository
import javax.inject.Singleton

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