package br.com.fiap.challenge.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.challenge.model.Schedule

@Dao
interface ScheduleDao {
    @Insert
    fun novoAgendamento(schedule: Schedule): Long

    @Query("SELECT * FROM tbl_schedule")
    fun buscarTodosAgendamentos(): List<Schedule>
}