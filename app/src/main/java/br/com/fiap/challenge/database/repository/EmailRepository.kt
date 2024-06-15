package br.com.fiap.challenge.database.repository

import android.content.Context
import br.com.fiap.challenge.database.dao.EmailDb
import br.com.fiap.challenge.model.Email

class EmailRepository(context: Context) {

    var db = EmailDb.getDatabase(context).emailDao()

    fun novoEmail(email: Email): Long {
        return db.novoEmail(email = email)
    }

    fun buscarEmailId(id: Long): Email {
        return db.buscarEmailId(id = id)
    }

    fun buscarEmailId(): List<Email> {
        return db.buscarTodosEmail()
    }
}
