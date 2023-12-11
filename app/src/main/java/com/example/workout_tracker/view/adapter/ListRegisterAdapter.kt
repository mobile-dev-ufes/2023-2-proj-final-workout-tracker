package com.example.workout_tracker.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_tracker.data.model.Register
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.databinding.RegisterLineBinding
import com.example.workout_tracker.databinding.RoutineLineBinding
import com.example.workout_tracker.view.OnRegisterListener
import com.example.workout_tracker.view.holder.ListRoutineViewHolder
import com.example.workout_tracker.view.OnRoutineListener
import com.example.workout_tracker.view.holder.ListRegisterViewHolder

class ListRegisterAdapter : RecyclerView.Adapter<ListRegisterViewHolder>() {

    private var registerList: List<Register> = listOf()
    private lateinit var listener: OnRegisterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRegisterViewHolder {
        val item = RegisterLineBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ListRegisterViewHolder(item, listener)
    }

    override fun onBindViewHolder(holder: ListRegisterViewHolder, position: Int) {
        holder.bindVH(registerList[position])
    }

    override fun getItemCount(): Int {
        return registerList.count()
    }

    fun updateProdList(list: List<Register>) {
        registerList = list
        notifyDataSetChanged()
    }

    fun setListener(registerListener: OnRegisterListener) {
        listener = registerListener
    }
}
