package org.d3if1102.noteq.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if1102.noteq.database.DatabaseNote
import org.d3if1102.noteq.model.Note
import org.d3if1102.noteq.network.MotivateApi
import org.d3if1102.noteq.network.MotivateApiService
import org.d3if1102.noteq.repository.NoteRepo

class NoteViewModel(application: Application) : AndroidViewModel(application){
    val repository: NoteRepo

    init {
        val dao = DatabaseNote.getDatabaseInstance(application).noteDao()
        repository = NoteRepo(dao)
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            try {
                val result = MotivateApi.service.getMotivate()
                Log.d("NoteViewModel", "Success: $result")
            } catch (e: Exception) {
                Log.d("NoteViewModel", "Failure: ${e.message}")
            }
        }
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