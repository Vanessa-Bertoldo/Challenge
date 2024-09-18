package br.com.fiap.challenge.service

import br.com.fiap.challenge.model.Email
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EmailService {

    @GET("buscaRecebidos/{idEmail}")
    fun getAllEmails(@Path("idEmail") idEmail: String): Call<List<Email>>

    @POST("enviarEmail")
    fun sendEmail(@Body email: Email): Call<Void>

    @GET("favoriteMessage/{idEmail}")
    fun atualizarImportancia(@Path("idEmail") idEmail: String): Call<Void>

    @PUT("desativarAtivar/{idEmail}")
    fun deletarEmail(@Path("idEmail") idEmail: String): Call<Void>
}