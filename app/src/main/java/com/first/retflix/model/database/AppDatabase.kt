package com.first.retflix.model.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Setslider::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun SetsliderDao(): SetsliderDao

    companion object {
        fun getDatabase(context: Context): AppDatabase {
            val db = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "dblocal"
            ).build()
            return db
        }
    }

}