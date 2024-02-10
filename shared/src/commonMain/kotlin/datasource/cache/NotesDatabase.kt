package datasource.cache

import com.raeandres.kmm.cache.AppDatabase
import datasource.DatabaseDriverFactory

internal class NotesDatabase(databaseDriverFactory: DatabaseDriverFactory){
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.notesDbQueries


    internal fun clearDatabase(){

    }
}