package com.example.workout_tracker.viewModel

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workout_tracker.data.model.Register
import com.example.workout_tracker.data.room.AppDatabase
import com.example.workout_tracker.util.Constants

class FragmentCreateRegisterViewModel(application: Application) : AndroidViewModel(application) {

    private var savedMsg = MutableLiveData<Int>()

    fun getIsSaved(): LiveData<Int> {
        return savedMsg
    }

    fun saveRegister(p: Register){
        val db = AppDatabase.getDatabase(getApplication()).RegisterDAO()
        var resp = 0L
        try {
            resp = db.insert(p)
            savedMsg.value = if(resp > 0) Constants.BD_MSGS.SUCCESS else Constants.BD_MSGS.FAIL
        } catch (e: SQLiteConstraintException){
            savedMsg.value = Constants.BD_MSGS.CONSTRAINT
        }
    }
}
