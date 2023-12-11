package com.example.workout_tracker.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.room.AppDatabase
import com.example.workout_tracker.util.Constants

class FragmentExercisesViewModel(application: Application): AndroidViewModel(application) {
    private var listMsg = MutableLiveData<Int>()
    private var exerciseList = MutableLiveData<List<Exercise>>()

    fun getListMsg(): LiveData<Int> {
        return listMsg
    }

    fun getExerciseList(): LiveData<List<Exercise>> {
        return exerciseList
    }

    fun getAllExercises(id: Long) {
        val db = AppDatabase.getDatabase(getApplication()).ExerciseDAO()
        try {
            val resp = db.getWorkoutWithExercisesById(id)
            if (resp == null) {
                listMsg.value = Constants.BD_MSGS.NOT_FOUND
            } else {
                listMsg.value = Constants.BD_MSGS.SUCCESS
                exerciseList.value = resp.exercises
            }
        } catch (e: Exception) {
            listMsg.value = Constants.BD_MSGS.FAIL
        }
    }
}