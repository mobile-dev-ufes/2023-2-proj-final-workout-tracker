package com.example.workout_tracker.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.workout_tracker.R
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
            findNavController().navigate(
                R.id.action_routines_to_create_routine,
                                    null,
                                    NavOptions.Builder()
                                        .setPopUpTo(R.id.routinesFragment, true)
                                        .build()
                            )
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
