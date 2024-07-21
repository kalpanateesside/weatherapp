package uk.ac.tees.w9633914.weatherman.presentation.forgot_password.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import uk.ac.tees.w9633914.weatherman.components.BackIcon
import uk.ac.tees.w9633914.weatherman.core.Constants.FORGOT_PASSWORD_SCREEN

@Composable
fun ForgotPasswordTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = FORGOT_PASSWORD_SCREEN
            )
        },
        navigationIcon = {
            BackIcon(
                navigateBack = navigateBack
            )
        }
    )
}