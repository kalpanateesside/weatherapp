package uk.ac.tees.mad.w9641722.weatherapp.domain.repository

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import uk.ac.tees.mad.w9641722.weatherapp.domain.model.Response

typealias SignUpResponse = Response<Boolean>
typealias SendEmailVerificationResponse = Response<Boolean>
typealias SignInResponse = Response<Boolean>
typealias ReloadUserResponse = Response<Boolean>
typealias SendPasswordResetEmailResponse = Response<Boolean>
typealias AuthStateResponse = StateFlow<Boolean>

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun firebaseSignUpWithEmailAndPassword(email: String, password: String): SignUpResponse

    suspend fun sendEmailVerification(): SendEmailVerificationResponse

    suspend fun firebaseSignInWithEmailAndPassword(email: String, password: String): SignInResponse

    suspend fun reloadFirebaseUser(): ReloadUserResponse

    suspend fun sendPasswordResetEmail(email: String): SendPasswordResetEmailResponse

    fun signOut()

    fun getAuthState(viewModelScope: CoroutineScope): AuthStateResponse
}