package org.d3if1102.noteq.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.d3if1102.noteq.R
import org.d3if1102.noteq.databinding.FragmentTambahNoteBinding


class TambahNote : Fragment() {

    lateinit var binding:FragmentTambahNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTambahNoteBinding.inflate(layoutInflater, container,false)


        return binding.root
    }

}