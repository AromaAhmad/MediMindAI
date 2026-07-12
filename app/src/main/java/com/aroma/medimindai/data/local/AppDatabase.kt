package com.aroma.medimindai.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import android.content.Context

@Database(entities = [ChatEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
        abstract fun chatDao(): ChatDao

        companion object {
                @Volatile
                private var INSTANCE: AppDatabase? = null

                fun getDatabase(context: Context): AppDatabase {
                        return INSTANCE ?: synchronized(this) {
                                val instance = Room.databaseBuilder(
                                        context,
                                        AppDatabase::class.java,
                                        "medimind_database"
                                )
                                        .fallbackToDestructiveMigration(true)
                                        .build()
                                INSTANCE = instance
                                instance
                        }
                }
        }
}