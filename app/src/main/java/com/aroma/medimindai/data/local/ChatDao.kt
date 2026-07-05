package com.aroma.medimindai.data.local
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ChatDao {
    @Insert suspend fun insertMessage(message: ChatEntity)
    @Delete suspend fun deletetMessage(message: ChatEntity)
    @Query("SELECT * FROM ChatEntity")
    suspend fun getAllMessages():List<ChatEntity>
            }