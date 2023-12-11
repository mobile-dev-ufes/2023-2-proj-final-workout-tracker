package com.example.workout_tracker.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.databinding.RoutineLineBinding
import com.example.workout_tracker.view.OnRoutineListener

class ListRoutineViewHolder(
    private val binding: RoutineLineBinding,
    private val listener: OnRoutineListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bindVH(routine: Routine){
        binding.textRoutineName.text = routine.name

        binding.routineIdButton.setOnClickListener {
            listener.onClick(routine)
        }
    }


}
