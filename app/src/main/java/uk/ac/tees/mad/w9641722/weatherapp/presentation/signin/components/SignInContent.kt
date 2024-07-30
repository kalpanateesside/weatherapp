package uk.ac.tees.mad.w9641722.weatherapp.presentation.signin.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.mad.w9641722.weatherapp.presentation.components.EmailField
import uk.ac.tees.mad.w9641722.weatherapp.presentation.components.PasswordField
import uk.ac.tees.mad.w9641722.weatherapp.presentation.components.SmallSpacer
import uk.ac.tees.mad.w9641722.weatherapp.api.Constants.EMPTY_STRING
import uk.ac.tees.mad.w9641722.weatherapp.api.Constants.FORGOT_PASSWORD
import uk.ac.tees.mad.w9641722.weatherapp.api.Constants.NO_ACCOUNT
import uk.ac.tees.mad.w9641722.weatherapp.api.Constants.SIGN_IN_BUTTON
import uk.ac.tees.mad.w9641722.weatherapp.api.Constants.VERTICAL_DIVIDER

import uk.ac.tees.mad.w9641722.weatherapp.R;
@Composable
@ExperimentalComposeUiApi
fun SignInContent(
    padding: PaddingValues,
    signIn: (email: String, password: String) -> Unit,
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
) {
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = EMPTY_STRING
                )
            )
        }
    )
    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = EMPTY_STRING
                )
            )
        }
    )
    val keyboard = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SmallSpacer()
        Image(
            painter = painterResource(id = R.drawable.weathernbg),
            contentDescription = "Logo")
        SmallSpacer()
        EmailField(
            email = email,
            onEmailValueChange = { newValue ->
                email = newValue
            }
        )
        SmallSpacer()
        PasswordField(
            password = password,
            onPasswordValueChange = { newValue ->
                password = newValue
            }
        )

        SmallSpacer()
        Button(
            onClick = {
                keyboard?.hide()
                signIn(email.text, password.text)
            }
        ) {
            Text(
                text = SIGN_IN_BUTTON,
                fontSize = 18.sp
            )
        }
        Row {
            Text(
                modifier = Modifier.clickable {
                    navigateToForgotPasswordScreen()
                },
                text = FORGOT_PASSWORD,
                fontSize = 18.sp
            )
            Text(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                text = VERTICAL_DIVIDER,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.clickable {
                    navigateToSignUpScreen()
                },
                text = NO_ACCOUNT,
                fontSize = 18.sp
            )
        }
    }
}