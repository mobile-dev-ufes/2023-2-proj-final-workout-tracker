package com.example.workout_tracker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.workout_tracker.R
import com.example.workout_tracker.data.model.Exercise
import com.example.workout_tracker.data.model.Routine
import com.example.workout_tracker.data.model.Workout
import com.example.workout_tracker.data.room.AppDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //testBD()
        //testInsertion()
        newTestDB()
    }

    private fun newTestDB(){
        val routineDao = AppDatabase.getDatabase(this).RoutineDAO()
        val workoutDAO = AppDatabase.getDatabase(this).WorkoutDAO()
        val exerciseDAO = AppDatabase.getDatabase(this).ExerciseDAO()

        val r1 = Routine(name = "Intermediario 2")
        val r1Id = routineDao.insert(r1)

        val w1 = Workout(name = "A", routineId = r1Id.toInt())
        val w1Id = workoutDAO.insert(w1)

        val ex1 = Exercise(name = "Bench", sets =  2, reps =  8, workoutId = w1Id.toInt())
        val ex2 = Exercise(name = "Squat", sets =  2, reps =  8, workoutId = w1Id.toInt())
        val ex1Id = exerciseDAO.insert(ex1)
        val ex2Id = exerciseDAO.insert(ex2)

        Toast.makeText(this, "Teste",Toast.LENGTH_LONG).show()
    }

//    private fun testInsertion() {
//        val context = this
//
//        // Cria uma instância do banco de dados
//        val db = AppDatabase.getDatabase(this)
//
//        // Cria uma rotina
//        val routine = Routine(name = "Minha Rotina")
//
//        // Cria um treino associado à rotina
//        val workout = Workout(name = "Meu Treino")
//
//        // Insere a rotina e o treino no banco de dados
//        val routineId = db.RoutineDAO().insert(routine).toInt()
//        val workoutId = db.WorkoutDAO().insert(workout).toInt()
//
//        // Cria um exercício associado ao treino
//        val exercise = Exercise(name = "Exercício 1", sets = 3, reps = 10, workoutId = workoutId)
//
//        // Insere o exercício no banco de dados
//        db.ExerciseDAO().insert(exercise)
//
//        // Obtém o treino com os exercícios associados
//        val workoutsWithExercisesList = db.WorkoutWithExercisesDAO().getWorkoutsWithExercises()
//
//        // Mostra informações de teste no Logcat
//        for (workoutWithExercises in workoutsWithExercisesList) {
//            val currentWorkout = workoutWithExercises.workout
//            val exercises = workoutWithExercises.exercises
//
//            Log.d("MainActivity", "Workout: ${currentWorkout.name}")
//
//            for (currentExercise in exercises) {
//                Log.d("MainActivity", " - Exercise: ${currentExercise.name}")
//            }
//        }
//    }

     fun testBD() {
        val db = AppDatabase.getDatabase(this)

        // Cria uma rotina
        val routine = Routine(name = "Minha Rotina")

        // Cria um treino associado à rotina
        val workout = Workout(name = "Meu Treino")

        // Insere a rotina e o treino no banco de dados
        val routineId = db.RoutineDAO().insert(routine).toInt()
        val workoutId = db.WorkoutDAO().insert(workout).toInt()

        // Cria um exercício associado ao treino
        val exercise = Exercise(name = "Exercício 1", sets = 3, reps = 10, workoutId = workoutId)

        // Insere o exercício no banco de dados
        db.ExerciseDAO().insert(exercise)

//        val dbe = AppDatabase.getDatabase(this).ExerciseDAO()
//        val dbr = AppDatabase.getDatabase(this).RoutineDAO()
//        val dbw = AppDatabase.getDatabase(this).WorkoutDAO()
//        Toast.makeText(this,"Teste",Toast.LENGTH_LONG).show()
//
//        val routine = Routine(name = "Minha Rotina")
//        val workout = Workout(name = "Meu Treino")
//        workout.exercises = listOf(
//            Exercise(name = "Exercício 1", sets = 3, reps = 10),
//            Exercise(name = "Exercício 2", sets = 4, reps = 12)
//        )
//        dbr.insert(routine)
//        val workoutId = dbw.insert(workout).toInt()
//        workout.exercises.forEach {
//            it.workoutId = workoutId
//            dbe.insert(it)
//        }

//        dbe.deleteAll()
//        dbr.deleteAll()
//        dbw.deleteAll()
//        val exer = Exercise().apply{
//            this.name = "Bench Press"
//        }
//        dbe.insert(exer)
//        val exer2 = Exercise().apply{
//            this.name = "Shoulder Press"
//        }
//        dbe.insert(exer2)
//        val rout = Routine().apply{
//            this.name = "MyRoutine"
//        }
//        val rout2 = Routine().apply{
//            this.name = "MyRoutine2"
//        }
//        dbr.insert(rout)
//        val work = Workout().apply{
//            this.name = "MyWorkout"
//            this.routineId = rout.id
//        }
//        val work2 = Workout().apply{
//            this.name = "MyWorkout2"
//            this.routineId = rout2.id
//        }
//        dbw.insert(work)
        // Daqui pra baixo não funciona
//        val dbrw = AppDatabase.getDatabase(this).RoutineWithWorkoutsDAO()
//        val lr = dbrw.getStuff()
//        for (r in lr) {
//            println(r)
//        }
    }
}