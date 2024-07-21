package uk.ac.tees.w9633914.weatherman.core

import android.content.Context
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import uk.ac.tees.w9633914.weatherman.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception) = Log.e(TAG, e.stackTraceToString())

        fun showMessage(
            context: Context,
            message: String?
        ) = makeText(context, message, LENGTH_LONG).show()
    }
}