package org.d3if1102.noteq.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.d3if1102.noteq.model.Note

@Dao
interface NoteDao {

    @Query("Select * From Note")
    fun getAllNote():LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Query("Delete from Note where id=:id")
    fun deleteNote(id: Int)

    @Update
    fun updateNote(note: Note)
}