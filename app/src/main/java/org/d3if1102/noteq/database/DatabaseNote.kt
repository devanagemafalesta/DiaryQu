package org.d3if1102.noteq.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if1102.noteq.dao.NoteDao
import org.d3if1102.noteq.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class DatabaseNote:RoomDatabase(){
    abstract fun noteDao(): NoteDao

    companion object{
        @Volatile
        var INSTANCE: DatabaseNote? = null

        fun getDatabaseInstance(context: Context): DatabaseNote {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val roomDatabaseInstance =
                    Room.databaseBuilder(context,DatabaseNote::class.java,"Note").allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }
    }
}