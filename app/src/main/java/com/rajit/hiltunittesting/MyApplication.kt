package com.rajit.hiltunittesting

import android.app.Application
import com.rajit.hiltunittesting.repository.ProductRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication: Application()