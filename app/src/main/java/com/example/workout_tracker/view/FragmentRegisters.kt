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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Register
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.databinding.FragmentRegistersBinding
import com.example.workout_tracker.databinding.FragmentRoutinesBinding
import com.example.workout_tracker.util.Constants
import com.example.workout_tracker.view.adapter.ListRegisterAdapter
import com.example.workout_tracker.view.adapter.ListRoutineAdapter
import com.example.workout_tracker.view.holder.ListRegisterViewHolder
import com.example.workout_tracker.viewModel.FragmentCreateRegisterViewModel
import com.example.workout_tracker.viewModel.FragmentRegisterViewModel
import com.example.workout_tracker.viewModel.FragmentRoutineViewModel

class FragmentRegisters : Fragment() {
    private var _binding: FragmentRegistersBinding? = null
    private val binding get() = _binding!!
    private lateinit var registerVM: FragmentRegisterViewModel
    private val adapter = ListRegisterAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentRegistersBinding.inflate(inflater, container, false)
        binding.recyclerListRegisters.layoutManager = LinearLayoutManager(activity)
        binding.recyclerListRegisters.adapter = adapter
        binding.searchRegisterButton.setOnClickListener {
            registerVM.getAllRegistersByName(binding.searchRegister.text.toString())
        }
        registerVM = ViewModelProvider(this).get(FragmentRegisterViewModel::class.java)
//        registerVM.getAllRegistersByName("")
        val listener = object : OnRegisterListener {
            override fun onClick(p: Register) {
//                val action = FragmentRoutinesDirections.actionRoutinesFragmentToWorkoutsFragment(p.id)
//                findNavController().navigate(action)
                Toast.makeText(activity, "${p.id}: ${p.exerciseName}", Toast.LENGTH_SHORT).show()
            }
        }
        adapter.setListener(listener)
        setObserver()
        return binding.root
    }
    fun setObserver() {
        registerVM.getListMsg().observe(viewLifecycleOwner, Observer {
            if (it == Constants.BD_MSGS.NOT_FOUND){
                Toast.makeText(activity, R.string.routine_list_not_found, Toast.LENGTH_SHORT).show()
            } else if (it == Constants.BD_MSGS.FAIL) {
                Toast.makeText(activity, R.string.routine_fail_search, Toast.LENGTH_SHORT).show()
            }
        })

        registerVM.getRegisterList().observe(viewLifecycleOwner, Observer {
            adapter.updateProdList(it)
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
