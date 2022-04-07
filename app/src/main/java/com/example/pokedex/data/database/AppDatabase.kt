package com.example.pokedex.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.data.model.Pokemon


//@Database(
//    entities = [Pokemon::class],
//    version = 1,
//    exportSchema = false
//)
//abstract class AppDatabase : RoomDatabase() {
//
////    abstract fun pokemonDao(): PokemonDao
//
////    companion object {
////        fun getInstance(context: Context): AppDatabase =
////            Room.databaseBuilder(context, AppDatabase::class.java, "pokemondb")
////                .addCallback(object : RoomDatabase.Callback() {
////                    override fun onCreate(db: SupportSQLiteDatabase) {
////                        fillInDb(context)
////                    }
////                }).build()
////
////        /**
////         * fill database with list of notes so we can test pagination
////         */
////        private fun fillInDb(context: Context) {
////            // inserts in Room are executed on the current thread, so we insert in the background
////            ioThread {
////                AppDatabase.getInstance(context).pokemonDao().insertAll(
////                    getData().map { NoteEntity(id = 0, noteText = it) }
////                )
////            }
////        }
////    }
//}