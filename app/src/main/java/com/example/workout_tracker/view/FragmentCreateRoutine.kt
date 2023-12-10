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
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.databinding.FragmentCreateRoutineBinding
import com.example.workout_tracker.util.Constants
import com.example.workout_tracker.viewModel.FragmentCreateRoutineViewModel


class FragmentCreateRoutine : Fragment(), View.OnClickListener {
    private var _binding: FragmentCreateRoutineBinding? = null
    private val binding get() = _binding!!
    private lateinit var createRoutineVM: FragmentCreateRoutineViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        createRoutineVM = ViewModelProvider(this).get(FragmentCreateRoutineViewModel::class.java)
        _binding = FragmentCreateRoutineBinding.inflate(inflater, container, false)
        binding.createRoutineButton.setOnClickListener(this)
        setObserver()
        return binding.root
    }

    override fun onClick(view: View) {
        if (view.id == R.id.createRoutineButton) {
            val p = Routine(name = binding.createRoutineName.text.toString())
            if (p.name == "") {
                Toast.makeText(activity, R.string.empty_routine_name_msg, Toast.LENGTH_LONG).show()
                return
            }
            createRoutineVM.saveRoutine(p)
            findNavController().navigate(R.id.action_create_routine_to_routines)
        }
    }

    private fun setObserver(){
        createRoutineVM.getIsSaved().observe(this, Observer {
            if (it == Constants.BD_MSGS.SUCCESS) {
                Toast.makeText(activity, R.string.success_create_routine, Toast.LENGTH_SHORT).show()
                clearEdits()
            } else if (it == Constants.BD_MSGS.FAIL) {
                Toast.makeText(activity, R.string.fail_create_routine, Toast.LENGTH_SHORT).show()
            } else if (it == Constants.BD_MSGS.CONSTRAINT) {
                Toast.makeText(activity, R.string.constraint_create_routine, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun clearEdits() {
        binding.createRoutineName.text.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
