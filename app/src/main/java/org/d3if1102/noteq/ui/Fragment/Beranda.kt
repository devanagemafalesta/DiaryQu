package org.d3if1102.noteq.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import org.d3if1102.noteq.R
import org.d3if1102.noteq.databinding.FragmentBerandaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [Beranda.newInstance] factory method to
 * create an instance of this fragment.
 */
class Beranda : Fragment() {

    lateinit var binding: FragmentBerandaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBerandaBinding.inflate(layoutInflater, container, false)

        binding.addNote.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_beranda_to_tambahNote)
        }
        return binding.root
    }
}