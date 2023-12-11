package com.example.workout_tracker.view

import com.example.workout_tracker.R
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
import com.example.workout_tracker.data.model.Register
import com.example.workout_tracker.databinding.FragmentCreateRegisterBinding
import com.example.workout_tracker.util.Constants
import com.example.workout_tracker.viewModel.FragmentCreateRegisterViewModel


class FragmentCreateRegister : Fragment(), View.OnClickListener {
    private var _binding: FragmentCreateRegisterBinding? = null
    private val binding get() = _binding!!
    private val args: FragmentCreateRegisterArgs by navArgs()
    private lateinit var createExerciseVM: FragmentCreateRegisterViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        createExerciseVM = ViewModelProvider(this).get(FragmentCreateRegisterViewModel::class.java)
        _binding = FragmentCreateRegisterBinding.inflate(inflater, container, false)
        binding.createRegisterButton.setOnClickListener(this)
        setObserver()
        return binding.root
    }

    override fun onClick(view: View) {
        if (view.id == R.id.createRegisterButton) {
            val sets = binding.createRegisterSets.text.toString()
            val reps = binding.createRegisterReps.text.toString()
            if (sets == "" || reps == "") {
                Toast.makeText(activity, R.string.empty_register_name_msg, Toast.LENGTH_LONG).show()
                return
            }
            val p = Register(exerciseId = args.exerciseId, sets = sets.toInt(), reps = reps.toInt())
            createExerciseVM.saveRegister(p)
            val action = FragmentCreateRegisterDirections.actionFragmentCreateRegisterToFragmentExercises(args.workoutId)
            findNavController().navigate(action)
        }
    }

    private fun setObserver(){
        createExerciseVM.getIsSaved().observe(viewLifecycleOwner, Observer {
            if (it == Constants.BD_MSGS.SUCCESS) {
                Toast.makeText(activity, R.string.success_create_register, Toast.LENGTH_SHORT).show()
            } else if (it == Constants.BD_MSGS.FAIL) {
                Toast.makeText(activity, R.string.fail_create_register, Toast.LENGTH_SHORT).show()
            } else if (it == Constants.BD_MSGS.CONSTRAINT) {
                Toast.makeText(activity, R.string.constraint_create_register, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
