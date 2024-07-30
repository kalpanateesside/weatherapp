package uk.ac.tees.mad.w9641722.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.ac.tees.mad.w9641722.weatherapp.navigation.Screen.ForgotPasswordScreen
import uk.ac.tees.mad.w9641722.weatherapp.navigation.Screen.SignInScreen
import uk.ac.tees.mad.w9641722.weatherapp.navigation.Screen.SignUpScreen
import uk.ac.tees.mad.w9641722.weatherapp.presentation.forgotPassword.ForgotPasswordScreen
import uk.ac.tees.mad.w9641722.weatherapp.presentation.signin.SignInScreen
import uk.ac.tees.mad.w9641722.weatherapp.presentation.signup.SignUpScreen

@Composable
@ExperimentalComposeUiApi
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SignInScreen.route
    ) {
        composable(
            route = SignInScreen.route
        ) {
            SignInScreen(
                navigateToForgotPasswordScreen = {
                    navController.navigate(ForgotPasswordScreen.route)
                },
                navigateToSignUpScreen = {
                    navController.navigate(SignUpScreen.route)
                }
            )
        }
        composable(
            route = ForgotPasswordScreen.route
        ) {
            ForgotPasswordScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = SignUpScreen.route
        ) {
            SignUpScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}