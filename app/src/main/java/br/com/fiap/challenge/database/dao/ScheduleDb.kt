package br.com.fiap.challenge.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.challenge.model.Schedule

@Database(entities = [Schedule::class], version = 1)
abstract class ScheduleDb : RoomDatabase() {

    abstract fun scheduleDao() : ScheduleDao

    companion object{
        private lateinit var instance: ScheduleDb

        fun getDatabase(context: Context) : ScheduleDb{
            if(!::instance.isInitialized){
                instance = Room
                    .databaseBuilder(
                        context,
                        ScheduleDb::class.java,
                        "email_db"
                    ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}