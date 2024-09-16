package br.com.fiap.challenge.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "http://localhost:8080"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getEmailService(): EmailService {
        return retrofitFactory.create(EmailService::class.java)
    }
}