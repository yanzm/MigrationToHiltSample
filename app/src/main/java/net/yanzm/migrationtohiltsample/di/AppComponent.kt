package net.yanzm.migrationtohiltsample.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import net.yanzm.migrationtohiltsample.MyApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        AppModule::class,
    ]
)
interface AppComponent {

    fun inject(app: MyApplication)

    @Component.Builder
    interface Builder {

        fun application(@BindsInstance application: Application): Builder

        fun build(): AppComponent
    }
}
