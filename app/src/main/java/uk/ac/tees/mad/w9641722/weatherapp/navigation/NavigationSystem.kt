package uk.ac.tees.w9633914.weatherman.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import uk.ac.tees.w9633914.weatherman.presentation.sign_in.SignInScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NavigationSystem(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "route1"){
        navigation(
            startDestination = "weather_screen",
            route = "route1"
        ){
            composable("weather_screen") { entry ->
                val viewModel = entry.weatherViewModel<WeatherViewModel>(navController = navController)
                val searchText = viewModel.searchText.collectAsState()
                val state = viewModel.getCurrentWeather(searchText.value).collectAsState(initial = null)
                val forecast = viewModel.getForecast(searchText.value).collectAsState(initial = null)

                WeatherScreen(
                    current = state,
                    onNavigate = {
                        navController.navigate("weather_detail_screen")
                    },
                    onNavigateToSearch = {
                        navController.navigate("search_screen")
                    },
                    onNavigateToLogin = {
                        navController.navigate("login_screen")
                    },
                    forecastState = forecast
                )


            }
            composable("weather_detail_screen"){ entry ->
                val viewModel = entry.weatherViewModel<WeatherViewModel>(navController = navController)
                val searchText = viewModel.searchText.collectAsState()
                val state = viewModel.getCurrentWeather(searchText.value).collectAsState(initial = null)

                WeatherDetailScreen(
                    current = state
                )
            }
            composable("search_screen"){ entry ->
                val viewModel = entry.weatherViewModel<WeatherViewModel>(navController = navController)
                val searchText = viewModel.searchText.collectAsState()
                val isSearching by viewModel.isSearching.collectAsState()
                val city by viewModel.city.collectAsState()

                SearchScreen(
                    navController = navController,
                    viewModel = viewModel,
                    searchText = searchText,
                    isSearching = isSearching,
                    city = city
                )
            }
            composable("login_screen"){ entry ->
                FirebaseAuth.getInstance().signOut()
                SignInScreen(
                    navigateToForgotPasswordScreen = {
                        navController.navigate(Screen.ForgotPasswordScreen.route)
                    },
                    navigateToSignUpScreen = {
                        navController.navigate(Screen.SignUpScreen.route)
                    }
                )
            }
        }
    }
}



@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.weatherViewModel(
    navController: NavController,
): T {
    val navGraphRoute =destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this){
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}