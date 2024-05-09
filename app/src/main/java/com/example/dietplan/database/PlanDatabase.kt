package com.example.dietplan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dietplan.model.Plan

@Database(entities = [Plan::class], version = 1)
abstract class PlanDatabase: RoomDatabase() {

    abstract fun getPlanDao(): PlanDao

    companion object{
        @Volatile
        private var instance: PlanDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context:Context) = instance ?:
        synchronized(LOCK){
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                PlanDatabase::class.java,
                "plan_db"
            ).build()
    }
}