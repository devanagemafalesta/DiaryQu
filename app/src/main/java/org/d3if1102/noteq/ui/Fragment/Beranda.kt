package org.d3if1102.noteq.ui.Fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.d3if1102.noteq.R
import org.d3if1102.noteq.databinding.FragmentBerandaBinding
import org.d3if1102.noteq.ui.Adapter.NoteAdapter
import org.d3if1102.noteq.viewmodel.NoteViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [Beranda.newInstance] factory method to
 * create an instance of this fragment.
 */
class Beranda : Fragment() {

    lateinit var binding: FragmentBerandaBinding
    val viewModel : NoteViewModel by viewModels()
    private var isLinearLayoutManager = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBerandaBinding.inflate(layoutInflater, container, false)



        viewModel.getNote().observe(viewLifecycleOwner, { noteList->
            binding.showAll.layoutManager = GridLayoutManager(requireContext(),2)
            binding.showAll.adapter= NoteAdapter(requireContext(),noteList)
        })

        binding.addNote.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_beranda_to_tambahNote)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_beranda_to_about)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}