package datasource

import model.Note

interface NotesDataSource {

    fun note(note: Note) : Note

}

expect fun getNoteFromDataSource(): NotesDataSource