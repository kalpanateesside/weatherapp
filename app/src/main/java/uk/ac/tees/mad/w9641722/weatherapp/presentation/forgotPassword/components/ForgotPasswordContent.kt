package uk.ac.tees.mad.w9641722.weatherapp.presentation.forgotPassword.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import uk.ac.tees.mad.w9641722.weatherapp.R
import uk.ac.tees.mad.w9641722.weatherapp.presentation.components.EmailField
import uk.ac.tees.mad.w9641722.weatherapp.presentation.components.SmallSpacer
import uk.ac.tees.mad.w9641722.weatherapp.api.Constants.EMPTY_STRING
import uk.ac.tees.mad.w9641722.weatherapp.api.Constants.RESET_PASSWORD_BUTTON

@Composable
fun ForgotPasswordContent(
    padding: PaddingValues,
    sendPasswordResetEmail: (email: String) -> Unit,
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
        EmailField(
            email = email,
            onEmailValueChange = { newValue ->
                email = newValue
            }
        )
        SmallSpacer()
        Button(
            onClick = {
                sendPasswordResetEmail(email.text)
            }
        ) {
            Text(
                text = RESET_PASSWORD_BUTTON,
                fontSize = 15.sp
            )
        }
    }
}