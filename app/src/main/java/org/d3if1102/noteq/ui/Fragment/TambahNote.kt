package org.d3if1102.noteq.ui.Fragment

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import org.d3if1102.noteq.R
import org.d3if1102.noteq.databinding.FragmentTambahNoteBinding
import org.d3if1102.noteq.model.Note
import org.d3if1102.noteq.viewmodel.NoteViewModel
import java.util.*


class TambahNote : Fragment() {

    lateinit var binding:FragmentTambahNoteBinding
    var mood: String = "netral"
    val viewModel : NoteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTambahNoteBinding.inflate(layoutInflater, container,false)

        binding.verySad.setOnClickListener{
            mood = "verysad"
            binding.verySad.setImageResource(R.drawable.ic_baseline_close_24)
            binding.sad.setImageResource(0)
            binding.netral.setImageResource(0)
            binding.happy.setImageResource(0)
            binding.veryHappy.setImageResource(0)

        }

        binding.sad.setOnClickListener{
            mood = "sad"
            binding.sad.setImageResource(R.drawable.ic_baseline_close_24)
            binding.verySad.setImageResource(0)
            binding.netral.setImageResource(0)
            binding.happy.setImageResource(0)
            binding.veryHappy.setImageResource(0)

        }

        binding.netral.setOnClickListener{
            mood = "netral"
            binding.netral.setImageResource(R.drawable.ic_baseline_close_24)
            binding.verySad.setImageResource(0)
            binding.sad.setImageResource(0)
            binding.happy.setImageResource(0)
            binding.veryHappy.setImageResource(0)

        }

        binding.happy.setOnClickListener{
            mood = "happy"
            binding.happy.setImageResource(R.drawable.ic_baseline_close_24)
            binding.verySad.setImageResource(0)
            binding.sad.setImageResource(0)
            binding.netral.setImageResource(0)
            binding.veryHappy.setImageResource(0)

        }

        binding.veryHappy.setOnClickListener{
            mood = "veryhappy"
            binding.veryHappy.setImageResource(R.drawable.ic_baseline_close_24)
            binding.verySad.setImageResource(0)
            binding.sad.setImageResource(0)
            binding.netral.setImageResource(0)
            binding.happy.setImageResource(0)

        }

        binding.simpanNoteBtn.setOnClickListener{
            createNote(it)
        }

        return binding.root
    }

    private fun createNote(it: View?){
        val judul = binding.editJudul.text.toString()
        val subJudul = binding.editSubJudul.text.toString()
        val deskripsi = binding.editDeskripsi.text.toString()

        val date = Date()
        val noteDate: CharSequence = DateFormat.format("MMMM d, yyyy ", date.time)

        val data = Note(
            null,
            judul = judul,
            subJudul = subJudul,
            deskripsi =deskripsi,
            date = noteDate.toString(),
            mood
        )
        viewModel.addNote(data)

        Toast.makeText(requireContext(), "Berhasil membuat Catatan", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_tambahNote_to_beranda)
    }

}