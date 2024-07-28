package uk.ac.tees.mad.w9641722.weatherapp.presentation.forgot_password

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.RESET_PASSWORD_MESSAGE
import uk.ac.tees.mad.w9641722.weatherapp.core.Utils.Companion.showMessage
import uk.ac.tees.mad.w9641722.weatherapp.presentation.forgot_password.components.ForgotPassword
import uk.ac.tees.mad.w9641722.weatherapp.presentation.forgot_password.components.ForgotPasswordContent
import uk.ac.tees.mad.w9641722.weatherapp.presentation.forgot_password.components.ForgotPasswordTopBar

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            ForgotPasswordTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            ForgotPasswordContent(
                padding = padding,
                sendPasswordResetEmail = { email ->
                    viewModel.sendPasswordResetEmail(email)
                }
            )
        }
    )

    ForgotPassword(
        navigateBack = navigateBack,
        showResetPasswordMessage = {
            showMessage(context, RESET_PASSWORD_MESSAGE)
        },
        showErrorMessage = { errorMessage ->
            showMessage(context, errorMessage)
        }
    )
}