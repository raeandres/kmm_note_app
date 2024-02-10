package datasource

import model.Note

class AndroidPlatform : NotesDataSource {
    override fun note(note: Note): Note {
        TODO("Not yet implemented")
    }
}

actual fun getNoteFromDataSource(): NotesDataSource = AndroidPlatform()
