package com.bigstep.videoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bigstep.videoapp.model.Result

@Database(entities = [Result::class], version = 3, exportSchema = false)
abstract class VideosDataBase : RoomDatabase() {
    abstract fun getVideosList(): VideosDao

}