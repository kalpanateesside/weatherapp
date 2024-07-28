package uk.ac.tees.mad.w9641722.weatherapp.presentation.profile.components

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import uk.ac.tees.mad.w9641722.weatherapp.components.ProgressBar
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.ACCESS_REVOKED_MESSAGE
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.REVOKE_ACCESS_MESSAGE
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.SENSITIVE_OPERATION_MESSAGE
import uk.ac.tees.mad.w9641722.weatherapp.core.Constants.SIGN_OUT_ITEM
import uk.ac.tees.mad.w9641722.weatherapp.core.Utils.Companion.print
import uk.ac.tees.mad.w9641722.weatherapp.core.Utils.Companion.showMessage
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.Response.*
import uk.ac.tees.mad.w9641722.weatherapp.presentation.profile.ProfileViewModel

@Composable
fun RevokeAccess(
    viewModel: ProfileViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    signOut: () -> Unit,
) {
    val context = LocalContext.current

    fun showRevokeAccessMessage() = coroutineScope.launch {
        val result = scaffoldState.snackbarHostState.showSnackbar(
            message = REVOKE_ACCESS_MESSAGE,
            actionLabel = SIGN_OUT_ITEM
        )
        if (result == SnackbarResult.ActionPerformed) {
            signOut()
        }
    }

    when(val revokeAccessResponse = viewModel.revokeAccessResponse) {
        is Loading -> ProgressBar()
        is Success -> {
            val isAccessRevoked = revokeAccessResponse.data
            LaunchedEffect(isAccessRevoked) {
                if (isAccessRevoked) {
                    showMessage(context, ACCESS_REVOKED_MESSAGE)
                }
            }
        }
        is Failure -> revokeAccessResponse.apply {
            LaunchedEffect(e) {
                print(e)
                if (e.message == SENSITIVE_OPERATION_MESSAGE) {
                    showRevokeAccessMessage()
                }
            }
        }
    }
}