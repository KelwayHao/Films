package com.kelway.films.utils

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.kelway.films.R

fun showDialog(context: Context, message: String) {
    MaterialAlertDialogBuilder(context)
        .setMessage(message)
        .setPositiveButton(context.getString(R.string.ok_button)) { dialog, _ ->
            dialog.cancel()
        }
        .show()
}