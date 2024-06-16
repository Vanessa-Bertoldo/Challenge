package br.com.fiap.challenge.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_schedule")
data class Schedule(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var titulo: String = "",
    var decricao: String = ""
)
