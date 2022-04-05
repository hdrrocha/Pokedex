package com.example.pokedex.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)