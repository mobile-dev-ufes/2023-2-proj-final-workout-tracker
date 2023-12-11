package com.example.workout_tracker.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.data.room.AppDatabase
import com.example.workout_tracker.util.Constants

class FragmentWorkoutViewModel(application: Application): AndroidViewModel(application) {
    private var listMsg = MutableLiveData<Int>()
    private var workoutList = MutableLiveData<List<Workout>>()

    fun getListMsg(): LiveData<Int> {
        return listMsg
    }

    fun getWorkoutList(): LiveData<List<Workout>> {
        return workoutList
    }

    fun getAllWorkouts(id: Long) {
        val db = AppDatabase.getDatabase(getApplication()).WorkoutDAO()
        try {
            val resp = db.getRoutineWithWorkoutsById(id)
            if (resp == null) {
                listMsg.value = Constants.BD_MSGS.NOT_FOUND
            } else {
                listMsg.value = Constants.BD_MSGS.SUCCESS
                workoutList.value = resp.workouts
            }
        } catch (e: Exception) {
            listMsg.value = Constants.BD_MSGS.FAIL
        }
    }
}