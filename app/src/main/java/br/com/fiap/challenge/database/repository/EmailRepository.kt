package br.com.fiap.challenge.database.repository

import android.content.Context
import br.com.fiap.challenge.database.dao.EmailDb
import br.com.fiap.challenge.model.Email

class EmailRepository(context: Context) {

    var db = EmailDb.getDatabase(context).emailDao()

    fun novoEmail(email: Email): Long {
        return db.novoEmail(email = email)
    }

    fun mudarImportanciaEmail(email: Email) {
        return db.mudarImportanciaEmail(email = email)
    }


    fun deletarEmail(email: Email){
        return db.deletarEmail(email)
    }

    fun buscarEmailId(id: Long?): Email {
        return db.buscarEmailId(id = id!!)
    }

    fun buscarTodosEmail(): List<Email> {
        return db.buscarTodosEmail()
    }

//    fun buscarTodosEmailAssunto(palavra: String): List<Email> {
//        return db.buscarTodosEventoAssunto(palavra)
//    }

    fun buscarTodosEventos(): List<Email> {
        return db.buscarTodosEvento()
    }


}
