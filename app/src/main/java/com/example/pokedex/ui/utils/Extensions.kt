package com.example.pokedex.ui.utils

import android.content.Context
import android.widget.Toast


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun String.extractId() = this.substringAfter("pokemon").replace("/", "").toInt()

fun String.getPicUrl(): String {
    val id = this.extractId()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
}