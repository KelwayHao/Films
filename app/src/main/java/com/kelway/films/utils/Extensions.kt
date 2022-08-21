package com.kelway.films.utils

import androidx.fragment.app.FragmentActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.kelway.films.R

fun FragmentActivity.showDialog(message: String) {
    MaterialAlertDialogBuilder(this)
        .setMessage(message)
        .setPositiveButton(this.getString(R.string.ok_button)) { dialog, _ ->
            dialog.cancel()
        }
        .show()
}

fun String.toDirectorNameWithInitials(): String {
    val name = this.split(" ")
    return "${name[2]} ${name[0].first()}.${name[1].first()}."
}