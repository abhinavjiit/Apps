package com.bigstep.videoapp.di

import android.util.Log
import com.bigstep.videoapp.NetworkApiCall
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Singleton
    @Provides
    @com.bigstep.videoapp.di.Retrofit
    fun providesRetrofit(
    ): Retrofit {
        Log.d("REROFIT", "fvjbfviubfivubfiuvb")
        val logginInt = HttpLoggingInterceptor()
        logginInt.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(logginInt).build()

        return Retrofit.Builder().baseUrl("https://itunes.apple.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    }

    @Singleton
    @Provides
    @GroupRetrofit
    fun providesGroupsRetrofit(
    ): Retrofit {
        Log.d("GROUPS", "fvjbfviubfivubfiuvb")
        val logginInt = HttpLoggingInterceptor()
        logginInt.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(logginInt).build()

        return Retrofit.Builder().baseUrl("https://itunes.apple.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun proviesVideoService(@GroupRetrofit retrofit: Retrofit): NetworkApiCall {
        return retrofit.create(NetworkApiCall::class.java)
    }


}