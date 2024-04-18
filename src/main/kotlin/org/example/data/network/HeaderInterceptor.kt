package org.example.data.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {


//        var TOKEN:String = prefs.getToken()
        var TOKEN:String = "1234"


        val request = chain.request().newBuilder()
            .addHeader(
                "Accept:", "application/json",
            )

        if(TOKEN.length > 0){
            request.addHeader(
                "Authorization", "Bearer $TOKEN"
            )
        }

        return chain.proceed(request.build())
    }
}