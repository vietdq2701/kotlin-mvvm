package com.codingcafe.mvvm.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingcafe.mvvm.room.entity.BlogCacheEntity

@Dao
interface BlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(blogEntity: BlogCacheEntity): Long

    @Query("SELECT * FROM blogs")
    suspend fun get(): List<BlogCacheEntity>
}