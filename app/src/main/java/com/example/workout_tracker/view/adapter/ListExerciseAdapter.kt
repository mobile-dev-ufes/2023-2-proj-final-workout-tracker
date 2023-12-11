package com.example.exercise_tracker.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.databinding.ExerciseLineBinding
import com.example.workout_tracker.view.OnExerciseListener
import com.example.workout_tracker.view.holder.ListExerciseViewHolder

class ListExerciseAdapter: RecyclerView.Adapter<ListExerciseViewHolder>() {

    private var exerciseList: List<Exercise> = listOf()
    private lateinit var listener: OnExerciseListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListExerciseViewHolder {
        val item = ExerciseLineBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListExerciseViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: ListExerciseViewHolder, position: Int) {
        holder.bindVH(exerciseList[position])
    }

    override fun getItemCount(): Int {
        return exerciseList.count()
    }

    fun updateProdList(list: List<Exercise>) {
        exerciseList = list
        notifyDataSetChanged()
    }

    fun setListener(exerciseListener: OnExerciseListener) {
        listener = exerciseListener
    }
}