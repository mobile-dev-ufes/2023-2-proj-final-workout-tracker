package com.example.workout_tracker.viewModel

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.room.AppDatabase
import com.example.workout_tracker.util.Constants

class FragmentCreateRoutineViewModel(application: Application) : AndroidViewModel(application) {

    private var savedMsg = MutableLiveData<Int>()

    fun getIsSaved(): LiveData<Int> {
        return savedMsg
    }

    fun saveRoutine(p: Routine){
        val db = AppDatabase.getDatabase(getApplication()).RoutineDAO()
        var resp = 0L
        try {
            resp = db.insert(p)
            savedMsg.value = if(resp > 0) Constants.BD_MSGS.SUCCESS else Constants.BD_MSGS.FAIL
        } catch (e: SQLiteConstraintException){
            savedMsg.value = Constants.BD_MSGS.CONSTRAINT
        }

    }
}