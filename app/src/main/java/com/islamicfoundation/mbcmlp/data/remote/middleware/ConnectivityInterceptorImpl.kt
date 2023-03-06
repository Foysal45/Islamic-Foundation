package com.islamicfoundation.mbcmlp.data.remote.middleware

import android.content.Context
import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.activity.isNetworkAvailable
import com.islamicfoundation.mbcmlp.middleware.ConnectivityInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptorImpl(
    context: Context
): ConnectivityInterceptor {

    private val appContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!appContext.isNetworkAvailable()) {
            throw IOException(appContext.getString(R.string.message_network_error))
        }
        return chain.proceed(chain.request())
    }
}