package com.example.workout_tracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.workout_tracker.databinding.FragmentCreateRoutineBinding
import com.example.workout_tracker.databinding.FragmentRoutinesBinding


class FragmentCreateRoutine : Fragment() {
    private var _binding: FragmentCreateRoutineBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentCreateRoutineBinding.inflate(inflater, container, false)
        binding.textCreateRoutine.text = "TESTANDO outro FRAGMENT"
        binding.textCreateRoutine.setOnClickListener {
            findNavController().navigate(R.id.action_create_routine_to_routines)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
