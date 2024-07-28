package uk.ac.tees.mad.w9641722.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.ac.tees.mad.w9641722.weatherapp.navigation.Screen.ForgotPasswordScreen
import uk.ac.tees.mad.w9641722.weatherapp.navigation.Screen.ProfileScreen
import uk.ac.tees.mad.w9641722.weatherapp.navigation.Screen.SignInScreen
import uk.ac.tees.mad.w9641722.weatherapp.navigation.Screen.SignUpScreen
import uk.ac.tees.mad.w9641722.weatherapp.navigation.Screen.VerifyEmailScreen
import uk.ac.tees.mad.w9641722.weatherapp.presentation.forgot_password.ForgotPasswordScreen
import uk.ac.tees.mad.w9641722.weatherapp.presentation.profile.ProfileScreen
import uk.ac.tees.mad.w9641722.weatherapp.presentation.sign_in.SignInScreen
import uk.ac.tees.mad.w9641722.weatherapp.presentation.sign_up.SignUpScreen
import uk.ac.tees.mad.w9641722.weatherapp.presentation.verify_email.VerifyEmailScreen

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
        composable(
            route = VerifyEmailScreen.route
        ) {
            VerifyEmailScreen(
                navigateToProfileScreen = {
                    navController.navigate(ProfileScreen.route) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = ProfileScreen.route
        ) {
            //ProfileScreen()
            NavigationSystem()
        }
    }
}