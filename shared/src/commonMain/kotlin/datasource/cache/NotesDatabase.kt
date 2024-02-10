package datasource.cache

import com.raeandres.kmm.cache.AppDatabase
import datasource.DatabaseDriverFactory
import model.Note

internal class NotesDatabase(databaseDriverFactory: DatabaseDriverFactory){
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.notesDbQueries


    internal fun clearDatabase(){
        dbQuery.removeAllNotes()
    }

    internal fun getAllNotes(): List<Note> {
        return dbQuery.selectAllNote(::noteMapping).executeAsList()
    }

    private fun noteMapping(
         id: Long,
         name: String,
         description: String?,
         createdDate: String
    ): Note{
        return Note(
            id = id.toString(),
            name = name,
            description = description ?: "",
            createdDate = createdDate
        )
    }


}