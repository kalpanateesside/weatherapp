package uk.ac.tees.w9633914.weatherman.presentation.sign_up.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import uk.ac.tees.w9633914.weatherman.components.ProgressBar
import uk.ac.tees.w9633914.weatherman.core.Utils.Companion.print
import uk.ac.tees.w9633914.weatherman.domain.model.Response.*
import uk.ac.tees.w9633914.weatherman.presentation.sign_up.SignUpViewModel

@Composable
fun SendEmailVerification(
    viewModel: SignUpViewModel = hiltViewModel()
) {
    when(val sendEmailVerificationResponse = viewModel.sendEmailVerificationResponse) {
        is Loading -> ProgressBar()
        is Success -> Unit
        is Failure -> sendEmailVerificationResponse.apply {
            LaunchedEffect(e) {
                print(e)
            }
        }
    }
}