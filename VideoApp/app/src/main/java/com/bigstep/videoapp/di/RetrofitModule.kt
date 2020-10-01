package com.bigstep.videoapp.di

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
    fun providesRetrofit(
    ): Retrofit {

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
    fun proviesVideoService(retrofit: Retrofit): NetworkApiCall {
        return retrofit.create(NetworkApiCall::class.java)
    }

}