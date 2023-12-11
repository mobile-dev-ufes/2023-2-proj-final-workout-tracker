package com.example.workout_tracker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.workout_tracker.R.id.fragmentContainerView
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.data.room.AppDatabase
import com.example.workout_tracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setToolbar()
        newTestDB()
        setContentView(binding.root)
    }

    private fun setToolbar() {
        val navHostFrag = supportFragmentManager.findFragmentById(fragmentContainerView) as NavHostFragment
        val navController = navHostFrag.navController
        binding.bottomNavMenu.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }


    private fun newTestDB(){
        val routineDao = AppDatabase.getDatabase(this).RoutineDAO()
        val workoutDAO = AppDatabase.getDatabase(this).WorkoutDAO()
        val exerciseDAO = AppDatabase.getDatabase(this).ExerciseDAO()

//        routineDao.deleteAll()
//        workoutDAO.deleteAll()
//        exerciseDAO.deleteAll()
//
//        val r1 = Routine(name = "Intermediario 2")
//        val r1Id = routineDao.insert(r1)
//
        val w1 = Workout(name = "A", routineId = 167)
        val w2 = Workout(name = "B", routineId = 167)
        val w3 = Workout(name = "C", routineId = 167)
        workoutDAO.insert(w1)
        workoutDAO.insert(w2)
        workoutDAO.insert(w3)
//
//        val ex1 = Exercise(name = "Bench", sets =  2, reps =  8, workoutId = w1Id)
//        val ex2 = Exercise(name = "Squat", sets =  2, reps =  8, workoutId = w1Id)
//        exerciseDAO.insert(ex1)
//        exerciseDAO.insert(ex2)
//
//        Toast.makeText(this, "Teste",Toast.LENGTH_LONG).show()
        return
    }


}