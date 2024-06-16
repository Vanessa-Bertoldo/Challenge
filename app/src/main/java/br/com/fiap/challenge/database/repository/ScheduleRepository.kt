package br.com.fiap.challenge.database.repository

import android.content.Context
import br.com.fiap.challenge.database.dao.ScheduleDb
import br.com.fiap.challenge.model.Schedule

class ScheduleRepository(context: Context) {
    var db = ScheduleDb.getDatabase(context).scheduleDao()

    fun novoAgendamento(schedule: Schedule): Long{
        return db.novoAgendamento(schedule = schedule)
    }

    fun buscarAgendamentos(): List<Schedule>{
        return db.buscarTodosAgendamentos()
    }
}