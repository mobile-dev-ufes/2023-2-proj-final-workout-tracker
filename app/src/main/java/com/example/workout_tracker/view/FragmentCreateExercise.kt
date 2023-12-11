package com.example.workout_tracker.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.databinding.FragmentCreateExerciseBinding
import com.example.workout_tracker.util.Constants
import com.example.workout_tracker.view.FragmentCreateExerciseArgs
import com.example.workout_tracker.view.FragmentCreateExerciseDirections
import com.example.workout_tracker.viewModel.FragmentCreateExerciseViewModel


class FragmentCreateExercise : Fragment(), View.OnClickListener {
    private var _binding: FragmentCreateExerciseBinding? = null
    private val binding get() = _binding!!
    private val args: FragmentCreateExerciseArgs by navArgs()
    private lateinit var createExerciseVM: FragmentCreateExerciseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        createExerciseVM = ViewModelProvider(this).get(FragmentCreateExerciseViewModel::class.java)
        _binding = FragmentCreateExerciseBinding.inflate(inflater, container, false)
        binding.createExerciseButton.setOnClickListener(this)
        setObserver()
        return binding.root
    }

    override fun onClick(view: View) {
        if (view.id == R.id.createExerciseButton) {
            val sets = binding.createExerciseSets.text.toString()
            val reps = binding.createExerciseReps.text.toString()
            val name = binding.createExerciseName.text.toString()
            if (name == "" || sets == "" || reps == "") {
                Toast.makeText(activity, R.string.empty_exercise_name_msg, Toast.LENGTH_LONG).show()
                return
            }
            val p = Exercise(workoutId = args.workoutId, name = name, sets = sets.toInt(), reps = reps.toInt())
            createExerciseVM.saveExercise(p)
            val action = FragmentCreateExerciseDirections.actionFragmentCreateExerciseToFragmentExercises(args.workoutId)
            findNavController().navigate(action)
        }
    }

    private fun setObserver(){
        createExerciseVM.getIsSaved().observe(viewLifecycleOwner, Observer {
            if (it == Constants.BD_MSGS.SUCCESS) {
                Toast.makeText(activity, R.string.success_create_exercise, Toast.LENGTH_SHORT).show()
                clearEdits()
            } else if (it == Constants.BD_MSGS.FAIL) {
                Toast.makeText(activity, R.string.fail_create_exercise, Toast.LENGTH_SHORT).show()
            } else if (it == Constants.BD_MSGS.CONSTRAINT) {
                Toast.makeText(activity, R.string.constraint_create_exercise, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun clearEdits() {
        binding.createExerciseName.text.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
