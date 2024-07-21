package uk.ac.tees.w9633914.weatherman.presentation.sign_up.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import uk.ac.tees.w9633914.weatherman.components.BackIcon
import uk.ac.tees.w9633914.weatherman.core.Constants.SIGN_UP_SCREEN

@Composable
fun SignUpTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = SIGN_UP_SCREEN
            )
        },
        navigationIcon = {
            BackIcon(
                navigateBack = navigateBack
            )
        }
    )
}