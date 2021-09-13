package net.yanzm.migrationtohiltsample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.yanzm.migrationtohiltsample.ui.main.MainActivity
import net.yanzm.migrationtohiltsample.ui.main.MainActivityModule

@Module
interface ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityModule.BindingModule::class])
    fun contributeMainActivityInjector(): MainActivity
}
