package com.rajit.hiltunittesting

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.rajit.hiltunittesting.di.NetworkModule
import dagger.Module
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

class CustomTestRunner: AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}