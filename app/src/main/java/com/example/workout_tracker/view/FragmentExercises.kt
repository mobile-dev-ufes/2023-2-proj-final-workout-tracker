package com.example.workout_tracker.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_tracker.view.adapter.ListExerciseAdapter
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.databinding.FragmentExercisesBinding
import com.example.workout_tracker.util.Constants
import com.example.workout_tracker.viewModel.FragmentExercisesViewModel


class FragmentExercises : Fragment() {
    private var _binding: FragmentExercisesBinding? = null
    private val binding get() = _binding!!
    private lateinit var exerciseVM: FragmentExercisesViewModel
    private val args: FragmentExercisesArgs by navArgs()
    private val adapter = ListExerciseAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentExercisesBinding.inflate(inflater, container, false)
        binding.recyclerListExercises.layoutManager = LinearLayoutManager(activity)
        binding.recyclerListExercises.adapter = adapter
        binding.createExercise.setOnClickListener {
            val action = FragmentExercisesDirections.actionFragmentExercisesToFragmentCreateExercise(args.workoutId)
            findNavController().navigate(action)
            /*,
                                    null,
                                    NavOptions.Builder()
                                        .setPopUpTo(R.id.exercisesFragment, true)
                                        .build()*/
        }
        exerciseVM = ViewModelProvider(this).get(FragmentExercisesViewModel::class.java)
        exerciseVM.getAllExercises(args.workoutId)
        val listener = object : OnExerciseListener {
            override fun onClick(p: Exercise) {
                val action = FragmentExercisesDirections.actionFragmentExercisesToFragmentCreateRegister(p.name, args.workoutId)
                findNavController().navigate(action)
//                Toast.makeText(activity, "${p.id}: ${p.name}", Toast.LENGTH_SHORT).show()
            }
        }
        adapter.setListener(listener)
        setObserver()
        return binding.root
    }
    fun setObserver() {
        exerciseVM.getListMsg().observe(viewLifecycleOwner, Observer {
            if (it == Constants.BD_MSGS.NOT_FOUND){
                Toast.makeText(activity, R.string.exercise_list_not_found, Toast.LENGTH_SHORT).show()
            } else if (it == Constants.BD_MSGS.FAIL) {
                Toast.makeText(activity, R.string.exercise_fail_search, Toast.LENGTH_SHORT).show()
            }
        })

        exerciseVM.getExerciseList().observe(viewLifecycleOwner, Observer {
            adapter.updateProdList(it)
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
