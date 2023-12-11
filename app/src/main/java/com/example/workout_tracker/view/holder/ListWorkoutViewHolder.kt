package com.example.workout_tracker.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.databinding.WorkoutLineBinding
import com.example.workout_tracker.view.OnWorkoutListener

class ListWorkoutViewHolder(
    private val binding: WorkoutLineBinding,
    private val listener: OnWorkoutListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bindVH(workout: Workout){
        binding.textWorkoutName.text = workout.name

        binding.workoutIdButton.setOnClickListener {
            listener.onClick(workout)
        }
    }
}