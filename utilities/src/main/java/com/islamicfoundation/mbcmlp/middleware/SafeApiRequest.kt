package com.islamicfoundation.mbcmlp.middleware

import android.util.Log
import com.islamicfoundation.mbcmlp.style.R
import com.islamicfoundation.mbcmlp.UiText
import com.islamicfoundation.mbcmlp.responses.ApiResponse
import org.json.JSONException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

abstract class SafeApiRequest {
    suspend fun <S : Any> apiRequest(call: suspend () -> Response<S>): ApiResponse<S> {
        return try {

            val response = call.invoke()
            ApiResponse.create(response)
        } catch (e: JSONException) {
            ApiResponse.create(
                UiText.StringResource(
                R.string.message_json_error
            ))
        } catch (e: IOException) {
            Log.d("call", ""+e.message)
            ApiResponse.create(
                UiText.StringResource(
                R.string.message_network_error
            ))
        } catch (e: SocketTimeoutException) {
            Log.d("call", "2 "+e.message)
            ApiResponse.create(
                UiText.StringResource(
                R.string.message_network_error
            ))
        } catch (e: Exception) {
            ApiResponse.create(
                UiText.StringResource(
                R.string.message_unknown_error
            ))
        }

    }

}