package com.example.workout_tracker.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workout_tracker.data.model.Register
import com.example.workout_tracker.data.room.AppDatabase
import com.example.workout_tracker.util.Constants

class FragmentRegisterViewModel(application: Application): AndroidViewModel(application) {
    private var listMsg = MutableLiveData<Int>()
    private var exerciseList = MutableLiveData<List<Register>>()

    fun getListMsg(): LiveData<Int> {
        return listMsg
    }

    fun getRegisterList(): LiveData<List<Register>> {
        return exerciseList
    }

    fun getAllRegistersByName(name: String) {
        if (name == "") {
            return
        }
        val db = AppDatabase.getDatabase(getApplication()).RegisterDAO()
        try {
            val resp = db.getExercisesWithRegistersByName(name)
            if (resp == null) {
                listMsg.value = Constants.BD_MSGS.NOT_FOUND
            } else {
                listMsg.value = Constants.BD_MSGS.SUCCESS
                exerciseList.value = resp.registers
            }
        } catch (e: Exception) {
            listMsg.value = Constants.BD_MSGS.FAIL
        }
    }
}