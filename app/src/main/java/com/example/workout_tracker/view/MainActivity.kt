package com.example.workout_tracker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.ExerciseModel
import com.example.workout_tracker.data.room.AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testBD()
    }

    private fun testBD() {
        val db = AppDatabase.getDatabase(this).ExerciseDAO()
        val exer = ExerciseModel().apply{
            this.name = "Bench Press"
            this.sets = 4
            this.reps = 10
        }
        val sdp = ExerciseModel().apply{
            this.name = "Shoulder Press"
            this.sets = 4
            this.reps = 10
        }
        db.insert(exer)
        db.insert(sdp)
    }
}