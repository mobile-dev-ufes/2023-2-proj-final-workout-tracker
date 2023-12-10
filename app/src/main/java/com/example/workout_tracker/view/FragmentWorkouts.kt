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
import com.example.workout_tracker.databinding.FragmentWorkoutsBinding


class FragmentWorkouts : Fragment() {
    private var _binding: FragmentWorkoutsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentWorkoutsBinding.inflate(inflater, container, false)
        binding.textWorkouts.text = "TESTANDO FRAGMENT WORKOUTS"
        binding.textWorkouts.setOnClickListener {
            findNavController().navigate(
                R.id.action_workouts_to_create_workout)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
