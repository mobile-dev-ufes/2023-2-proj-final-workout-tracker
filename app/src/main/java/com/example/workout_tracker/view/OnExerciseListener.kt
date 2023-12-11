package com.example.workout_tracker.view

import com.example.workout_tracker.data.model.Exercise

interface OnExerciseListener {
    fun onClick(p: Exercise)
}