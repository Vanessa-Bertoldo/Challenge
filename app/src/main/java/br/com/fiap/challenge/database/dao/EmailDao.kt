package br.com.fiap.challenge.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.challenge.model.EmailDB

@Dao
interface EmailDao {

    @Insert
    fun novoEmail(emailDB: EmailDB): Long
    @Update
    fun mudarImportanciaEmail(emailDB: EmailDB)

    @Delete
    fun deletarEmail(emailDB: EmailDB)

    @Query("SELECT * FROM tbl_email ORDER BY st_flag_importante DESC")
    fun buscarTodosEmail(): List<EmailDB>

    @Query("SELECT * FROM tbl_email ORDER BY dt_evento")
    fun buscarTodosEvento(): List<EmailDB>

//    @Query("SELECT * FROM tbl_email WHERE nm_assunto LIKE :palavra ORDER BY dt_evento")
//    fun buscarTodosEventoAssunto(palavra: String): List<Email>

    @Query("SELECT * FROM tbl_email WHERE id = :id")
    fun buscarEmailId(id: Long): EmailDB
}