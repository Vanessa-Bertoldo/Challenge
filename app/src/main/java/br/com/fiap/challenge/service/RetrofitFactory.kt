package br.com.fiap.challenge.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "http://10.0.2.2:5116/Message/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getEmailService(): EmailService {
        return retrofitFactory.create(EmailService::class.java)
    }
}