package com.example.workout_tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.workout_tracker.databinding.FragmentRoutinesBinding


class FragmentRoutines : Fragment() {
    private var _binding: FragmentRoutinesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentRoutinesBinding.inflate(inflater, container, false)
        binding.textRoutine.text = "TESTANDO FRAGMENT"
        binding.textRoutine.setOnClickListener {
            findNavController().navigate(R.id.action_routines_to_create_routine)
        }
        return binding.root
    }

    override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
    }
}
