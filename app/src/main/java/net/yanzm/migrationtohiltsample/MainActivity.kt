package net.yanzm.migrationtohiltsample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.android.*
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Scope


class MainActivity : AppCompatActivity(), HasAndroidInjector {

    /**
     * この中の Map には AndroidInjector<MainActivity> と AndroidInjector<MainFragment> がいる
     */
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

class MainFragment : Fragment() {

    @Inject
    lateinit var dialogSupport: DialogSupport

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ll = LinearLayout(requireContext())
        val button = Button(requireContext())
        button.text = "Click"
        button.setOnClickListener {
            dialogSupport.showConfirmDialog()
        }
        ll.addView(button)
        return ll
    }

}

/**
 * @param context : Activity Context でないといけない
 */
class DialogSupport(private val context: Context) {

    fun showConfirmDialog() {
        AlertDialog.Builder(context)
            .setTitle("タイトル")
            .setMessage("メッセージ")
            .setPositiveButton("OK", null)
            .show()
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Module
interface ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityModule.BindingModule::class])
    fun contributeMainActivityInjector(): MainActivity
}

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
