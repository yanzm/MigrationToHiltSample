package net.yanzm.migrationtohiltsample

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import net.yanzm.migrationtohiltsample.di.AppComponent
import net.yanzm.migrationtohiltsample.di.DaggerAppComponent
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    // この中の Map には AndroidInjector<MainActivity> だけがいる
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}
