package com.example.pokedex.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.data.model.Pokemon

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Pokemon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(note: List<Pokemon>)

    @Query("SELECT * FROM pokemon")
    fun pokemons(): List<Pokemon>
}