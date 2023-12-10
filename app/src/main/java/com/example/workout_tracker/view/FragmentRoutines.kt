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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.databinding.FragmentRoutinesBinding
import com.example.workout_tracker.util.Constants
import com.example.workout_tracker.viewModel.FragmentCreateRoutineViewModel
import com.example.workout_tracker.viewModel.FragmentRoutineViewModel


class FragmentRoutines : Fragment() {
    private var _binding: FragmentRoutinesBinding? = null
    private val binding get() = _binding!!
    private lateinit var routineVM: FragmentRoutineViewModel
    private val adapter = ListRoutineAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentRoutinesBinding.inflate(inflater, container, false)
        binding.recyclerListRoutines.layoutManager = LinearLayoutManager(activity)
        binding.recyclerListRoutines.adapter = adapter
        binding.createRoutine.setOnClickListener {
            findNavController().navigate( R.id.action_routines_to_create_routine)
            /*,
                                    null,
                                    NavOptions.Builder()
                                        .setPopUpTo(R.id.routinesFragment, true)
                                        .build()*/
        }
        routineVM = ViewModelProvider(this).get(FragmentRoutineViewModel::class.java)
        routineVM.getAllRoutines()
        val listener = object : OnRoutineListener {
            override fun onClick(p: Routine) {
                Toast.makeText(activity, p.name, Toast.LENGTH_SHORT).show()
            }
        }
        adapter.setListener(listener)
        setObserver()
        return binding.root
    }
    fun setObserver() {
        routineVM.getListMsg().observe(viewLifecycleOwner, Observer {
            if (it == Constants.BD_MSGS.NOT_FOUND){
                Toast.makeText(activity, R.string.routine_list_not_found, Toast.LENGTH_SHORT).show()
            } else if (it == Constants.BD_MSGS.FAIL) {
                Toast.makeText(activity, R.string.routine_fail_search, Toast.LENGTH_SHORT).show()
            }
        })

        routineVM.getProdList().observe(viewLifecycleOwner, Observer {
            adapter.updateProdList(it)
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
