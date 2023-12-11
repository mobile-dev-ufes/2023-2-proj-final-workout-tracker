package com.example.workout_tracker.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.databinding.FragmentRoutinesBinding
import com.example.workout_tracker.databinding.FragmentWorkoutsBinding
import com.example.workout_tracker.util.Constants
import com.example.workout_tracker.view.adapter.ListRoutineAdapter
import com.example.workout_tracker.view.adapter.ListWorkoutAdapter
import com.example.workout_tracker.viewModel.FragmentRoutineViewModel
import com.example.workout_tracker.viewModel.FragmentWorkoutViewModel


class FragmentWorkouts : Fragment() {
    private var _binding: FragmentWorkoutsBinding? = null
    private val binding get() = _binding!!
    private lateinit var workoutVM: FragmentWorkoutViewModel
    private val args: FragmentWorkoutsArgs by navArgs()
    private val adapter = ListWorkoutAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentWorkoutsBinding.inflate(inflater, container, false)
//        binding.textWorkouts.text = "TESTANDO FRAGMENT WORKOUTS"
//        binding.textWorkouts.setOnClickListener {
//            findNavController().navigate(
//                R.id.action_workouts_to_create_workout)
//        }
        binding.recyclerListWorkouts.layoutManager = LinearLayoutManager(activity)
        binding.recyclerListWorkouts.adapter = adapter
        binding.createWorkout.setOnClickListener {
            val action = FragmentWorkoutsDirections.actionWorkoutsToCreateWorkout(args.routineId)
            findNavController().navigate(action)
//            findNavController().navigate( R.id.action_workouts_to_create_workout)
            /*,
                                    null,
                                    NavOptions.Builder()
                                        .setPopUpTo(R.id.workoutsFragment, true)
                                        .build()*/
        }
        workoutVM = ViewModelProvider(this).get(FragmentWorkoutViewModel::class.java)
        workoutVM.getAllWorkouts(args.routineId)
        val listener = object : OnWorkoutListener {
            override fun onClick(p: Workout) {
                val action = FragmentWorkoutsDirections.actionWorkoutsFragmentToFragmentExercises(p.id)
                findNavController().navigate(action)
//                Toast.makeText(activity, "${p.id}: ${p.name}", Toast.LENGTH_SHORT).show()
            }
        }
        adapter.setListener(listener)
        setObserver()
        Toast.makeText(activity, "${args.routineId}", Toast.LENGTH_LONG).show()
        return binding.root
    }

    fun setObserver() {
        workoutVM.getListMsg().observe(viewLifecycleOwner, Observer {
            if (it == Constants.BD_MSGS.NOT_FOUND){
                Toast.makeText(activity, R.string.workout_list_not_found, Toast.LENGTH_SHORT).show()
            } else if (it == Constants.BD_MSGS.FAIL) {
                Toast.makeText(activity, R.string.workout_fail_search, Toast.LENGTH_SHORT).show()
            }
        })

        workoutVM.getWorkoutList().observe(viewLifecycleOwner, Observer {
            adapter.updateProdList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
