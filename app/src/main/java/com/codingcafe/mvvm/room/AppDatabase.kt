package com.codingcafe.mvvm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codingcafe.mvvm.room.dao.BlogDao
import com.codingcafe.mvvm.room.entity.BlogCacheEntity

@Database(entities = [BlogCacheEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun blogDao(): BlogDao

    companion object{
        val DATABASE_NAME: String = "app_db"
    }
}