package net.yanzm.migrationtohiltsample.ui

import android.content.Context
import androidx.appcompat.app.AlertDialog

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
