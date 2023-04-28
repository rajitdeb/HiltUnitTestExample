package com.rajit.hiltunittesting.di

import android.content.Context
import androidx.room.Room
import com.rajit.hiltunittesting.db.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [SingletonComponent::class], replaces = [DatabaseModule::class])
@Module
class TestDatabaseModule {

    @Singleton
    @Provides
    fun provideTestDB(
        @ApplicationContext context: Context
    ): ProductDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            ProductDatabase::class.java
        ).allowMainThreadQueries().build()
    }

}