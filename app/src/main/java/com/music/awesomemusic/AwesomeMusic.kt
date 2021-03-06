package com.music.awesomemusic

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.Context
import com.music.awesomemusic.di.AppInjector
import com.music.awesomemusic.di.components.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

open class AwesomeMusic : Application(), HasActivityInjector, HasServiceInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingAndroidServiceInjector: DispatchingAndroidInjector<Service>
    lateinit var appComponent: AppComponent

    companion object {
        fun getAppComponent(context: Context): AppComponent = (context as AwesomeMusic).appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppInjector.init(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> =
        dispatchingAndroidInjector

    override fun serviceInjector(): AndroidInjector<Service> = dispatchingAndroidServiceInjector
}