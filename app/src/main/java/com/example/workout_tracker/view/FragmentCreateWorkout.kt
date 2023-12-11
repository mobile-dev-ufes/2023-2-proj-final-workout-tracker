package com.example.workout_tracker.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.databinding.FragmentCreateWorkoutBinding
import com.example.workout_tracker.databinding.FragmentRoutinesBinding
import com.example.workout_tracker.databinding.FragmentWorkoutsBinding
import com.example.workout_tracker.viewModel.FragmentCreateRoutineViewModel
import com.example.workout_tracker.viewModel.FragmentCreateWorkoutViewModel


class FragmentCreateWorkout : Fragment(), View.OnClickListener{
    private var _binding: FragmentCreateWorkoutBinding? = null
    private val binding get() = _binding!!
    private val args: FragmentCreateWorkoutArgs by navArgs()
    private lateinit var createWorkoutVM: FragmentCreateWorkoutViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        createWorkoutVM = ViewModelProvider(this).get(FragmentCreateWorkoutViewModel::class.java)
        _binding = FragmentCreateWorkoutBinding.inflate(inflater, container, false)
        binding.createWorkoutButton.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(view: View) {
        val p = Workout(routineId = args.routineId, name = binding.createWorkoutName.text.toString())
        if (p.name == "") {
            Toast.makeText(activity, R.string.empty_workout_name_msg, Toast.LENGTH_LONG).show()
            return
        }
        createWorkoutVM.saveWorkout(p)
        val action = FragmentCreateWorkoutDirections.actionCreateWorkoutToWorkouts(args.routineId)
        findNavController().navigate(action)
//        findNavController().navigate(R.id.action_create_workout_to_workouts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
