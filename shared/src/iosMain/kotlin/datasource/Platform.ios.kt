package datasource

import model.Note

class IOSPlatform: NotesDataSource {
    override fun note(note: Note): Note {
        TODO("Not yet implemented")
    }
}

actual fun getNoteFromDataSource(): NotesDataSource = IOSPlatform()
