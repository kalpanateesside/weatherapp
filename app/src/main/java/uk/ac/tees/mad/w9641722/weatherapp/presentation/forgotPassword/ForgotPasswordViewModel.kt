package uk.ac.tees.mad.w9641722.weatherapp.presentation.forgotPassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.Response.Loading
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.Response.Success
import uk.ac.tees.mad.w9641722.weatherapp.domain.repository.AuthRepository
import uk.ac.tees.mad.w9641722.weatherapp.domain.repository.SendPasswordResetEmailResponse
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    var sendPasswordResetEmailResponse by mutableStateOf<SendPasswordResetEmailResponse>(Success(false))

    fun sendPasswordResetEmail(email: String) = viewModelScope.launch {
        sendPasswordResetEmailResponse = Loading
        sendPasswordResetEmailResponse = repo.sendPasswordResetEmail(email)
    }
}