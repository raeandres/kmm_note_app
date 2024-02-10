package datasource

import com.raeandres.kmm.cache.AppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import model.Note

class IOSPlatform: NotesDataSource {
    override fun note(note: Note): Note {
      return note
    }
}

actual fun getNoteFromDataSource(): NotesDataSource = IOSPlatform()


actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "Notes.db")
    }

}
