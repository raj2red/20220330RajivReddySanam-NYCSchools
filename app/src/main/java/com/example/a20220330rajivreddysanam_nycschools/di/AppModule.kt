package com.example.a20220330rajivreddysanam_nycschools.di

import android.app.Application
import androidx.room.Room
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db.SchoolDatabase
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.SchoolRepository
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.SchoolRepositoryImpl
import com.example.a20220330rajivreddysanam_nycschools.util.network.APIRepository
import com.example.a20220330rajivreddysanam_nycschools.util.network.NetworkCall
import com.example.a20220330rajivreddysanam_nycschools.util.network.RetrofitAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): SchoolDatabase {
        return Room.databaseBuilder(
            app,
            SchoolDatabase::class.java,
            "school_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideSchoolRepository(db: SchoolDatabase): SchoolRepository {
        return SchoolRepositoryImpl(db)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(RetrofitAPI.gson))
        .baseUrl("https://data.cityofnewyork.us/resource/")
        .build()

    @Singleton
    @Provides
    fun provideNetworkCall(retrofit: Retrofit): NetworkCall = retrofit.create(NetworkCall::class.java)

    @Singleton
    @Provides
    fun providesAPIRepository(apiService: NetworkCall) = APIRepository(apiService)
}