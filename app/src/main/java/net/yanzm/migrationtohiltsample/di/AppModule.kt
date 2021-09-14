package net.yanzm.migrationtohiltsample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.yanzm.migrationtohiltsample.network.DefaultIdStore
import net.yanzm.migrationtohiltsample.network.IdStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideIdStore(@ApplicationContext context: Context): IdStore {
        return DefaultIdStore(context)
    }
}
