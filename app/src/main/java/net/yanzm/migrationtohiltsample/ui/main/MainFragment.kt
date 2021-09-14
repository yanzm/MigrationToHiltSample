package net.yanzm.migrationtohiltsample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import net.yanzm.migrationtohiltsample.network.IdStore
import net.yanzm.migrationtohiltsample.ui.DialogSupport
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    lateinit var dialogSupport: DialogSupport

    @Inject
    lateinit var idStore: IdStore

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ll = LinearLayout(requireContext())
        ll.orientation = LinearLayout.VERTICAL

        val textView = TextView(requireContext())
        textView.text = "Id : " + idStore.getId()
        ll.addView(textView)

        val button = Button(requireContext())
        button.text = "Click"
        button.setOnClickListener {
            dialogSupport.showConfirmDialog()
        }
        ll.addView(button)
        return ll
    }
}
