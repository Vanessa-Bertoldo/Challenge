package br.com.fiap.challenge.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.challenge.model.Email

@Dao
interface EmailDao {

    @Insert
    fun novoEmail(email: Email): Long

    @Query("SELECT * FROM tbl_email")
    fun buscarTodosEmail(): List<Email>

    @Query("SELECT * FROM tbl_email WHERE id = :id")
    fun buscarEmailId(id: Long): Email
}