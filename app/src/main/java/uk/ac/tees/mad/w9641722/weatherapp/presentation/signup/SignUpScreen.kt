package uk.ac.tees.mad.w9641722.weatherapp.presentation.signup

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import uk.ac.tees.mad.w9641722.weatherapp.api.Constants.VERIFY_EMAIL_MESSAGE
import uk.ac.tees.mad.w9641722.weatherapp.api.Utils.Companion.showMessage
import uk.ac.tees.mad.w9641722.weatherapp.presentation.signup.components.SendEmailVerification
import uk.ac.tees.mad.w9641722.weatherapp.presentation.signup.components.SignUp
import uk.ac.tees.mad.w9641722.weatherapp.presentation.signup.components.SignUpContent
import uk.ac.tees.mad.w9641722.weatherapp.presentation.signup.components.SignUpTopBar

@Composable
@ExperimentalComposeUiApi
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            SignUpTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            SignUpContent(
                padding = padding,
                signUp = { email, password ->
                    viewModel.signUpWithEmailAndPassword(email, password)
                },
                navigateBack = navigateBack
            )
        }
    )

    SignUp(
        sendEmailVerification = {
            viewModel.sendEmailVerification()
        },
        showVerifyEmailMessage = {
            showMessage(context, VERIFY_EMAIL_MESSAGE)
        }
    )

    SendEmailVerification()
}