package com.example.workout_tracker.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.databinding.RoutineLineBinding
import com.example.workout_tracker.view.holder.ListRoutineViewHolder
import com.example.workout_tracker.view.OnRoutineListener

class ListRoutineAdapter : RecyclerView.Adapter<ListRoutineViewHolder>() {

    private var routineList: List<Routine> = listOf()
    private lateinit var listener: OnRoutineListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRoutineViewHolder {
        val item = RoutineLineBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListRoutineViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: ListRoutineViewHolder, position: Int) {
        holder.bindVH(routineList[position])
    }

    override fun getItemCount(): Int {
        return routineList.count()
    }

    fun updateProdList(list: List<Routine>) {
        routineList = list
        notifyDataSetChanged()
    }

    fun setListener(routineListener: OnRoutineListener) {
        listener = routineListener
    }
}
