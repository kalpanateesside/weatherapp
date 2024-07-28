package uk.ac.tees.mad.w9641722.weatherapp.presentation.sign_in

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
import uk.ac.tees.mad.w9641722.weatherapp.domain.repository.SignInResponse
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repo: AuthRepository
): ViewModel() {
    var signInResponse by mutableStateOf<SignInResponse>(Success(false))
        private set

    fun signInWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        signInResponse = Loading
        signInResponse = repo.firebaseSignInWithEmailAndPassword(email, password)
    }
}