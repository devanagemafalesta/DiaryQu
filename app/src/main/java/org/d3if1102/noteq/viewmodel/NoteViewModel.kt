package org.d3if1102.noteq.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import org.d3if1102.noteq.database.DatabaseNote
import org.d3if1102.noteq.model.Note
import org.d3if1102.noteq.repository.NoteRepo

class NoteViewModel(application: Application) : AndroidViewModel(application){
    val repository: NoteRepo

    init {
        val dao = DatabaseNote.getDatabaseInstance(application).noteDao()
        repository = NoteRepo(dao)
    }

    fun addNote(note: Note){
        repository.insertNote(note)
    }

    fun getNote(): LiveData<List<Note>> = repository.getAllNote()

    fun deleteNote(id:Int){
        repository.deleteNote(id)
    }

    fun updateNote(note: Note){
        repository.updateNote(note)
    }
}