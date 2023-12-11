package com.example.workout_tracker.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.workout_tracker.data.model.Register
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.databinding.RegisterLineBinding
import com.example.workout_tracker.databinding.RoutineLineBinding
import com.example.workout_tracker.view.OnRegisterListener
import com.example.workout_tracker.view.OnRoutineListener

class ListRegisterViewHolder(
    private val binding: RegisterLineBinding,
    private val listener: OnRegisterListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bindVH(register: Register){
        binding.textName.text = "${register.exerciseName}:"
        binding.textSets.text = "Sets: ${register.sets}"
        binding.textReps.text = "Reps: ${register.reps}"
    }


}
