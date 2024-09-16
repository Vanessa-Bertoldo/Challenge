package br.com.fiap.challenge.model

data class Email (

    val id: Long,
    val nomeAssunto: String,
    val texto: String,
    val flagImportante: Boolean,
    val flagDeletado: Boolean,
    val nomeDestinatario: String,
    val nomeRemetente: String,
    val dataEvento: String

    //@SerializedName("")

)