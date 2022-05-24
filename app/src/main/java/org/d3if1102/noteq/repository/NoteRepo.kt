package org.d3if1102.noteq.repository

import androidx.lifecycle.LiveData
import org.d3if1102.noteq.dao.NoteDao
import org.d3if1102.noteq.model.Note

class NoteRepo(val dao: NoteDao) {
    fun getAllNote():LiveData<List<Note>>{
        return dao.getAllNote()
    }

    fun insertNote(note: Note){
        dao.insertNote(note)
    }

    fun deleteNote(id: Int){
        dao.deleteNote(id)
    }

    fun updateNote(note: Note){
        dao.updateNote(note)
    }

}