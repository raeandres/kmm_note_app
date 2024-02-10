package datasource

import android.content.Context
import com.raeandres.kmm.cache.AppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import model.Note

class AndroidPlatform : NotesDataSource {
    override fun note(note: Note): Note {
        return note
    }


}

actual fun getNoteFromDataSource(): NotesDataSource = AndroidPlatform()


actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDatabase.Schema, context = context, "Notes.db")
    }

}

