package net.yanzm.migrationtohiltsample.di

import android.app.Application
import dagger.Module
import dagger.Provides
import net.yanzm.migrationtohiltsample.MyApplication
import net.yanzm.migrationtohiltsample.network.DefaultIdStore
import net.yanzm.migrationtohiltsample.network.IdStore
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideIdStore(application: Application): IdStore {
        return DefaultIdStore(application)
    }
}
