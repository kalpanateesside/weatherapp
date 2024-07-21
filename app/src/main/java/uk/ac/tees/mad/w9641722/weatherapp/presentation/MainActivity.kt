package uk.ac.tees.w9633914.weatherman.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import uk.ac.tees.w9633914.weatherman.navigation.NavGraph
import uk.ac.tees.w9633914.weatherman.navigation.NavigationSystem
import uk.ac.tees.w9633914.weatherman.navigation.Screen.ProfileScreen
import uk.ac.tees.w9633914.weatherman.navigation.Screen.SignInScreen
import uk.ac.tees.w9633914.weatherman.navigation.Screen.VerifyEmailScreen

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            NavGraph(
                navController = navController
            )
            AuthState()
        }
    }

    @Composable
    private fun AuthState() {
        val isUserSignedOut = viewModel.getAuthState().collectAsState().value
        if (isUserSignedOut) {
            NavigateToSignInScreen()
        } else {
            NavigationSystem()
        }
    }

    @Composable
    public fun NavigateToSignInScreen() = navController.navigate(SignInScreen.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }

    @Composable
    private fun NavigateToProfileScreen() = navController.navigate(ProfileScreen.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }

    @Composable
    private fun NavigateToVerifyEmailScreen() = navController.navigate(VerifyEmailScreen.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }
}