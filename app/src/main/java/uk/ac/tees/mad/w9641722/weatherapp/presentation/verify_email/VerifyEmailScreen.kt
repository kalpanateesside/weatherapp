package uk.ac.tees.w9633914.weatherman.presentation.verify_email

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import uk.ac.tees.w9633914.weatherman.components.TopBar
import uk.ac.tees.w9633914.weatherman.core.Constants.EMAIL_NOT_VERIFIED_MESSAGE
import uk.ac.tees.w9633914.weatherman.core.Constants.VERIFY_EMAIL_SCREEN
import uk.ac.tees.w9633914.weatherman.core.Utils.Companion.showMessage
import uk.ac.tees.w9633914.weatherman.presentation.profile.ProfileViewModel
import uk.ac.tees.w9633914.weatherman.presentation.profile.components.RevokeAccess
import uk.ac.tees.w9633914.weatherman.presentation.verify_email.components.ReloadUser
import uk.ac.tees.w9633914.weatherman.presentation.verify_email.components.VerifyEmailContent

@Composable
fun VerifyEmailScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToProfileScreen: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopBar(
                title = VERIFY_EMAIL_SCREEN,
                signOut = {
                    viewModel.signOut()
                }
            )
        },
        content = { padding ->
            VerifyEmailContent(
                padding = padding,
                reloadUser = {
                    viewModel.reloadUser()
                }
            )
        },
        scaffoldState = scaffoldState
    )

    ReloadUser(
        navigateToProfileScreen = {
            if (viewModel.isEmailVerified) {
                navigateToProfileScreen()
            } else {
                showMessage(context, EMAIL_NOT_VERIFIED_MESSAGE)
            }
        }
    )

    RevokeAccess(
        scaffoldState = scaffoldState,
        coroutineScope = coroutineScope,
        signOut = {
            viewModel.signOut()
        }
    )
}