package net.yanzm.migrationtohiltsample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    // この中の Map には AndroidInjector<MainActivity> と AndroidInjector<MainFragment> がいる
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, MainFragment())
                .commit()
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}
