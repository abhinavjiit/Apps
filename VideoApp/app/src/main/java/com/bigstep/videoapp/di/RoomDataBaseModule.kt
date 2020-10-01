package com.bigstep.videoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bigstep.videoapp.db.VideosDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomDataBaseModule(private val context: Context) {
    @Singleton
    @Provides
    fun providesDataBase(): VideosDataBase {
        return buildDataBase(context)
    }

    private fun buildDataBase(context: Context) = Room.databaseBuilder(
        context.applicationContext,
        VideosDataBase::class.java,
        "videos_db"
    ).build()


    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    }
}