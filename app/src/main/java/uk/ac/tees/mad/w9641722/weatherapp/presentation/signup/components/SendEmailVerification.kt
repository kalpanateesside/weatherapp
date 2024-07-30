package uk.ac.tees.mad.w9641722.weatherapp.presentation.signup.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import uk.ac.tees.mad.w9641722.weatherapp.presentation.components.ProgressBar
import uk.ac.tees.mad.w9641722.weatherapp.api.Utils.Companion.print
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.Response.*
import uk.ac.tees.mad.w9641722.weatherapp.presentation.signup.SignUpViewModel

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