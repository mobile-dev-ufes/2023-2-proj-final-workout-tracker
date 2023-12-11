package com.example.workout_tracker.view

import com.example.workout_tracker.data.model.Workout

interface OnWorkoutListener {
    fun onClick(p: Workout)
}