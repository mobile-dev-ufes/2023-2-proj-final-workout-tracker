package com.example.workout_tracker.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.databinding.WorkoutLineBinding
import com.example.workout_tracker.view.OnWorkoutListener
import com.example.workout_tracker.view.holder.ListWorkoutViewHolder

class ListWorkoutAdapter: RecyclerView.Adapter<ListWorkoutViewHolder>() {

    private var workoutList: List<Workout> = listOf()
    private lateinit var listener: OnWorkoutListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListWorkoutViewHolder {
        val item = WorkoutLineBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListWorkoutViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: ListWorkoutViewHolder, position: Int) {
        holder.bindVH(workoutList[position])
    }

    override fun getItemCount(): Int {
        return workoutList.count()
    }

    fun updateProdList(list: List<Workout>) {
        workoutList = list
        notifyDataSetChanged()
    }

    fun setListener(workoutListener: OnWorkoutListener) {
        listener = workoutListener
    }
}