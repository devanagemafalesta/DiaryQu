package org.d3if1102.noteq.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import org.d3if1102.noteq.R
import org.d3if1102.noteq.databinding.ItemNoteBinding
import org.d3if1102.noteq.model.Note
import org.d3if1102.noteq.ui.Fragment.BerandaDirections

class NoteAdapter(requireContext: Context, val noteList: List<Note>) : RecyclerView.Adapter<NoteAdapter.notesViewHolder>(){
    class notesViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = noteList[position]
            holder.binding.judulNote.text= data.judul
            holder.binding.subJudulNote.text = data.subJudul
            holder.binding.tanggalNote.text=data.date

        when(data.mood) {
            "verysad" -> {
                holder.binding.viewMood.setBackgroundResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            }
            "sad" -> {
                holder.binding.viewMood.setBackgroundResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
            }
            "netral" -> {
                holder.binding.viewMood.setBackgroundResource(R.drawable.ic_baseline_sentiment_satisfied_24)
            }
            "happy" -> {
                holder.binding.viewMood.setBackgroundResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
            }
            "veryhappy" -> {
                holder.binding.viewMood.setBackgroundResource(R.drawable.ic_baseline_sentiment_very_satisfied_24)
            }
        }

        holder.binding.root.setOnClickListener{
            val action=BerandaDirections.actionBerandaToEditNote(data)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount() = noteList.size

}