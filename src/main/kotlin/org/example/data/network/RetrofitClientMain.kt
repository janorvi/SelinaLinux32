package org.example.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientMain {

    private const val SERVER_URL = "52.67.139.133"
    //production//
    //private const val SERVER_URL = "54.235.196.163"
    private const val BASE_URL = "http://$SERVER_URL:8080/api/" //nuevotest
//    private const val BASE_URL = "https://api-sae-demo1.valliu.co/api/" //demo

    val webserviceMain: WebServicesClient by lazy{

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

        Retrofit.Builder()
//            .baseUrl(UserApplication.prefs.getStorage("baseUrl"))
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(WebServicesClient::class.java)
    }
}