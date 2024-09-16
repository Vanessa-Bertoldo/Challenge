package br.com.fiap.challenge.service

import br.com.fiap.challenge.model.Email
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EmailService {

    @GET("/receive/{idEmail}")
    fun getAllEmails(@Path("idEmail") idEmail: String): Call<List<Email>>

    @POST()
    fun sendEmail(): Call<Email>
}