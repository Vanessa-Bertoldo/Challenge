package br.com.fiap.challenge.database.repository

import android.content.Context
import br.com.fiap.challenge.database.dao.EmailDb
import br.com.fiap.challenge.model.EmailDB

class EmailRepository(context: Context) {

    var db = EmailDb.getDatabase(context).emailDao()

    fun novoEmail(emailDB: EmailDB): Long {
        return db.novoEmail(emailDB = emailDB)
    }

    fun mudarImportanciaEmail(emailDB: EmailDB) {
        return db.mudarImportanciaEmail(emailDB = emailDB)
    }


    fun deletarEmail(emailDB: EmailDB){
        return db.deletarEmail(emailDB)
    }

    fun buscarEmailId(id: Long?): EmailDB {
        return db.buscarEmailId(id = id!!)
    }

    fun buscarTodosEmail(): List<EmailDB> {
        return db.buscarTodosEmail()
    }

//    fun buscarTodosEmailAssunto(palavra: String): List<Email> {
//        return db.buscarTodosEventoAssunto(palavra)
//    }

    fun buscarTodosEventos(): List<EmailDB> {
        return db.buscarTodosEvento()
    }


}
