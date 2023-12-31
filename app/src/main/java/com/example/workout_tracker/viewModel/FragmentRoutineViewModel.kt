package com.example.workout_tracker.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.room.AppDatabase
import com.example.workout_tracker.util.Constants

class FragmentRoutineViewModel(application: Application) : AndroidViewModel(application) {

    private var listMsg = MutableLiveData<Int>()
    private var routineList = MutableLiveData<List<Routine>>()

    fun getListMsg(): LiveData<Int> {
        return listMsg
    }

    fun getRoutineList(): LiveData<List<Routine>> {
        return routineList
    }

    fun getAllRoutines() {
        val db = AppDatabase.getDatabase(getApplication()).RoutineDAO()
        try {
            val resp = db.getAll()
            if (resp == null) {
                listMsg.value = Constants.BD_MSGS.NOT_FOUND
            } else {
                listMsg.value = Constants.BD_MSGS.SUCCESS
                routineList.value = resp
            }
        } catch (e: Exception) {
            listMsg.value = Constants.BD_MSGS.FAIL
        }
    }


}
