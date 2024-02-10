package datasource

import com.squareup.sqldelight.db.SqlDriver
import model.Note

interface NotesDataSource {

    fun note(note: Note) : Note

}

expect fun getNoteFromDataSource(): NotesDataSource
expect class DatabaseDriverFactory{
    fun createDriver(): SqlDriver
}