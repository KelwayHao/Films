package com.kelway.films.utils

fun String.toDirectorNameWithInitials(): String {
    val name = this.split(" ")
    return "${name[2]} ${name[0].first()}.${name[1].first()}."
}