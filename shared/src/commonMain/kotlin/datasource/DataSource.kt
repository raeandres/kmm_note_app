package datasource

import com.squareup.sqldelight.db.SqlDriver
import datasource.network.NotesApi
import model.Note

interface NotesDataSource {

    companion object {
        val INSTANCE : NotesDataSource by lazy (LazyThreadSafetyMode.SYNCHRONIZED) { NotesApi.INSTANCE }
    }

   suspend fun getAllNotes(): List<Note>
   fun addNote()
   fun removeNote()

   suspend fun testApi(): String

}

expect class DatabaseDriverFactory{
    fun createDriver(): SqlDriver
}