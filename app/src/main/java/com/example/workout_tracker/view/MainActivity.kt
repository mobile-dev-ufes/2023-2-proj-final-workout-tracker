package com.example.workout_tracker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.workout_tracker.R
import com.example.workout_tracker.FragmentRoutines
import com.example.workout_tracker.R.id.fragmentContainerView
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.data.room.AppDatabase
import com.example.workout_tracker.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        newTestDB()
    }

    private fun setToolbar() {
        val navHostFrag = supportFragmentManager.findFragmentById(fragmentContainerView) as NavHostFragment
        val navController = navHostFrag.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }


    private fun newTestDB(){
        val routineDao = AppDatabase.getDatabase(this).RoutineDAO()
        val workoutDAO = AppDatabase.getDatabase(this).WorkoutDAO()
        val exerciseDAO = AppDatabase.getDatabase(this).ExerciseDAO()
        val routineWithWorkoutsDAO = AppDatabase.getDatabase(this).RoutineWithWorkoutsDAO()
        val workoutWithExercisesDAO = AppDatabase.getDatabase(this).WorkoutWithExercisesDAO()

        routineDao.deleteAll()
        workoutDAO.deleteAll()
        exerciseDAO.deleteAll()

        val r1 = Routine(name = "Intermediario 2")
        val r1Id = routineDao.insert(r1)

        val w1 = Workout(name = "A", routineId = r1Id)
        val w1Id = workoutDAO.insert(w1)

        val ex1 = Exercise(name = "Bench", sets =  2, reps =  8, workoutId = w1Id)
        val ex2 = Exercise(name = "Squat", sets =  2, reps =  8, workoutId = w1Id)
        exerciseDAO.insert(ex1)
        exerciseDAO.insert(ex2)

        val routineWithWorkouts = routineWithWorkoutsDAO.getRoutineWithWorkoutsById(r1Id)
        Log.d("RoutineWithWorkouts", routineWithWorkouts.toString())

        val workoutWithExercises = workoutWithExercisesDAO.getWorkoutWithExercisesById(w1Id)
        Log.d("WorkoutWithExercises", workoutWithExercises.toString())

        Toast.makeText(this, "Teste",Toast.LENGTH_LONG).show()
    }


}