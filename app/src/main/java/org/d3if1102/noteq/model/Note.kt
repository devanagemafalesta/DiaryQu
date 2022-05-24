package org.d3if1102.noteq.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
class Note(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var judul: String?,
    var subJudul: String?,
    var deskripsi:String?,
    var date:String?,
    var mood:String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(judul)
        parcel.writeString(subJudul)
        parcel.writeString(deskripsi)
        parcel.writeString(date)
        parcel.writeString(mood)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }
}