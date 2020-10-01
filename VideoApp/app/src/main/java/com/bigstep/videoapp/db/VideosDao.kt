package com.bigstep.videoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bigstep.videoapp.model.Result

@Dao
interface VideosDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateVideosDataBase(videoEntity: Result)

    @Query("SELECT * FROM Videos_list")
    suspend fun getVideosFromDatabase(): List<Result>?
}