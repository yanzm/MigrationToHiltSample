package net.yanzm.migrationtohiltsample.ui.main

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import net.yanzm.migrationtohiltsample.ui.DialogSupport
import net.yanzm.migrationtohiltsample.di.ActivityScope
import net.yanzm.migrationtohiltsample.di.FragmentScope

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideDialogSupport(activity: MainActivity): DialogSupport {
        return DialogSupport(activity)
    }

    @Module
    interface BindingModule {
        @FragmentScope
        @ContributesAndroidInjector
        fun contributeMainFragmentInjector(): MainFragment
    }
}
