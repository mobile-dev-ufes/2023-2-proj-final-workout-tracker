package com.example.workout_tracker.view.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.databinding.ExerciseLineBinding
import com.example.workout_tracker.databinding.RoutineLineBinding
import com.example.workout_tracker.view.OnExerciseListener
import com.example.workout_tracker.view.OnRoutineListener

class ListExerciseViewHolder(
    private val binding: ExerciseLineBinding,
    private val listener: OnExerciseListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bindVH(exercise: Exercise){
        binding.textExerciseName.text = "${exercise.name} (${exercise.sets}/${exercise.reps})"

        binding.exerciseIdButton.setOnClickListener {
            listener.onClick(exercise)
        }
    }


}
