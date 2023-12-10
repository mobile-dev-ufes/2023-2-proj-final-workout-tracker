package com.example.workout_tracker.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.workout_tracker.R
import com.example.workout_tracker.databinding.FragmentCreateWorkoutBinding
import com.example.workout_tracker.databinding.FragmentRoutinesBinding
import com.example.workout_tracker.databinding.FragmentWorkoutsBinding


class FragmentCreateWorkout : Fragment() {
    private var _binding: FragmentCreateWorkoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentCreateWorkoutBinding.inflate(inflater, container, false)
        binding.textCreateWorkout.text = "TESTANDO FRAGMENT create WORKOUTS"
        binding.textCreateWorkout.setOnClickListener {
            findNavController().navigate(
                R.id.action_create_workout_to_workouts)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
