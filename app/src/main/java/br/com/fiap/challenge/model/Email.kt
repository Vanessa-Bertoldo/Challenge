package br.com.fiap.challenge.model

import com.google.gson.annotations.SerializedName


data class Email(

    @SerializedName("Id")val id: String,
    @SerializedName("Subject") val nomeAssunto: String?,
    @SerializedName("Message") val texto: String,
    @SerializedName("IsFavorite") val flagImportante: Boolean,
    @SerializedName("IsDelete") val flagDeletado: Boolean,
    @SerializedName("isSpam") val flagSpam: Boolean,
    @SerializedName("isRead") val flagRead: Boolean,
    @SerializedName("SenderName") val nomeDestinatario: String,
    @SerializedName("RemententName") val nomeRemetente: String,
    val dataEvento: String?

) {
    constructor(
        nomeAssunto: String,
        texto: String,
        flagImportante: Boolean,
        flagDeletado: Boolean,
        flagSpam: Boolean,
        flagRead: Boolean,
        nomeDestinatario: String,
        nomeRemetente: String
    ) : this(
        id = "",
        nomeAssunto = nomeAssunto,
        texto = texto,
        flagImportante = flagImportante,
        flagDeletado = flagDeletado,
        flagSpam = flagSpam,
        flagRead = flagRead,
        nomeDestinatario = nomeDestinatario,
        nomeRemetente = nomeRemetente,
        dataEvento = null
    )
}