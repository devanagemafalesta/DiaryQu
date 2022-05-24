package org.d3if1102.noteq.ui.Fragment

import android.os.Bundle
import android.text.format.DateFormat
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.d3if1102.noteq.R
import org.d3if1102.noteq.databinding.FragmentEditNoteBinding
import org.d3if1102.noteq.model.Note
import org.d3if1102.noteq.viewmodel.NoteViewModel
import java.util.*

class EditNote : Fragment() {

    val oldNote by navArgs<EditNoteArgs>()
    lateinit var binding: FragmentEditNoteBinding
    var mood: String = "netral"
    val viewModel : NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditNoteBinding.inflate(layoutInflater, container,false)

        binding.editJudul.setText(oldNote.data.judul)
        binding.editSubJudul.setText(oldNote.data.subJudul)
        binding.editDeskripsi.setText(oldNote.data.deskripsi)
        setHasOptionsMenu(true)

        when(oldNote.data.mood) {
            "verysad" -> {
                mood = "verysad"
                binding.verySad.setImageResource(R.drawable.ic_baseline_close_24)
                binding.sad.setImageResource(0)
                binding.netral.setImageResource(0)
                binding.happy.setImageResource(0)
                binding.veryHappy.setImageResource(0)
            }
            "sad" -> {
                mood = "sad"
                binding.sad.setImageResource(R.drawable.ic_baseline_close_24)
                binding.verySad.setImageResource(0)
                binding.netral.setImageResource(0)
                binding.happy.setImageResource(0)
                binding.veryHappy.setImageResource(0)
            }
            "netral" -> {
                mood = "netral"
                binding.netral.setImageResource(R.drawable.ic_baseline_close_24)
                binding.verySad.setImageResource(0)
                binding.sad.setImageResource(0)
                binding.happy.setImageResource(0)
                binding.veryHappy.setImageResource(0)
            }
            "happy" -> {
                mood = "happy"
                binding.happy.setImageResource(R.drawable.ic_baseline_close_24)
                binding.verySad.setImageResource(0)
                binding.sad.setImageResource(0)
                binding.netral.setImageResource(0)
                binding.veryHappy.setImageResource(0)
            }
            "veryhappy" -> {
                mood = "veryhappy"
                binding.veryHappy.setImageResource(R.drawable.ic_baseline_close_24)
                binding.verySad.setImageResource(0)
                binding.sad.setImageResource(0)
                binding.netral.setImageResource(0)
                binding.happy.setImageResource(0)
            }
        }

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

        binding.editSimpanNoteBtn.setOnClickListener{
            updateNote(it)
        }
        return binding.root
    }
    private fun updateNote(it:View?){
        val judul = binding.editJudul.text.toString()
        val subJudul = binding.editSubJudul.text.toString()
        val deskripsi = binding.editDeskripsi.text.toString()

        val date = Date()
        val noteDate: CharSequence = DateFormat.format("MMMM d, yyyy ", date.time)

        val data = Note(
            oldNote.data.id,
            judul = judul,
            subJudul = subJudul,
            deskripsi =deskripsi,
            date = noteDate.toString(),
            mood
        )
        viewModel.updateNote(data)

        Toast.makeText(requireContext(), "Berhasil Update Catatan", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editNote_to_beranda)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.menu_delete){
            val bottomSheet:BottomSheetDialog= BottomSheetDialog(requireContext())
            bottomSheet.setContentView(R.layout.dialog_konfirmasi_hapus)

            val textViewYes=bottomSheet.findViewById<TextView>(R.id.dialog_yes)
            val textViewNo=bottomSheet.findViewById<TextView>(R.id.dialog_no)

            textViewNo?.setOnClickListener{
                bottomSheet.dismiss()
            }

            textViewYes?.setOnClickListener {
                viewModel.deleteNote(oldNote.data.id!!)
                view?.findNavController()!!?.navigate(R.id.beranda)
                bottomSheet.dismiss()
            }

            bottomSheet.show()
        }
        return super.onOptionsItemSelected(item)
    }

}