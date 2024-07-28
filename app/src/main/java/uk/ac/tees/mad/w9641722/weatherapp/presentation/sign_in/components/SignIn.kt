package uk.ac.tees.mad.w9641722.weatherapp.presentation.sign_in.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import uk.ac.tees.mad.w9641722.weatherapp.components.ProgressBar
import uk.ac.tees.mad.w9641722.weatherapp.core.Utils.Companion.print
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.Response.*
import uk.ac.tees.mad.w9641722.weatherapp.presentation.sign_in.SignInViewModel

@Composable
fun SignIn(
    viewModel: SignInViewModel = hiltViewModel(),
    showErrorMessage: (errorMessage: String?) -> Unit
) {
    when(val signInResponse = viewModel.signInResponse) {
        is Loading -> ProgressBar()
        is Success -> Unit
        is Failure -> signInResponse.apply {
            LaunchedEffect(e) {
                print(e)
                showErrorMessage(e.message)
            }
        }
    }
}