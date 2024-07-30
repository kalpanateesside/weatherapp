package uk.ac.tees.mad.w9641722.weatherapp.navigation

import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.FORGOT_PASSWORD_SCREEN
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.PROFILE_SCREEN
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.SIGN_IN_SCREEN
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.VERIFY_EMAIL_SCREEN
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.SIGN_UP_SCREEN

sealed class Screen(val route: String) {
    object SignInScreen: Screen(SIGN_IN_SCREEN)
    object ForgotPasswordScreen: Screen(FORGOT_PASSWORD_SCREEN)
    object SignUpScreen: Screen(SIGN_UP_SCREEN)
}