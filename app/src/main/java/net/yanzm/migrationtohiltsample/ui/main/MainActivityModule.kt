package net.yanzm.migrationtohiltsample.ui.main

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import net.yanzm.migrationtohiltsample.ui.DialogSupport

@Module
@InstallIn(ActivityComponent::class)
class MainActivityModule {

    @ActivityScoped
    @Provides
    fun provideDialogSupport(@ActivityContext context: Context): DialogSupport {
        return DialogSupport(context)
    }
}
