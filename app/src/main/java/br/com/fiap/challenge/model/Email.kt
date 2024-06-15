package br.com.fiap.challenge.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_email")
data class Email(

    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo("nm_assunto") var nomeAssunto: String,
    var texto: String,
    @ColumnInfo("st_flag_importante") var flagImportante: Boolean = false,
    @ColumnInfo("st_delecao") var flagDeletado: Boolean = false,
    @ColumnInfo("nm_destinatario") var nomeDestinatario: String,
    @ColumnInfo("nm_remetente") var nomeRemetente: String
    )
