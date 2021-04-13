package com.example.studentservice

import com.example.studentservice.FacultyServiceInteraction.getFacultyForStudent
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
@RequestMapping("/students")
class StudentController {
    @GetMapping("/all")
    fun getStudents(): List<Student> {
        println("found all students")
        return listOf(Student(Random.nextInt(), "Nikita", "Katkov"))
    }

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Int): Student? {
        println("found student with id: $id")
        val facultyForStudent = getFacultyForStudent(id).orEmpty()
        return Student(id, "Nikita", "Katkov", facultyForStudent)
    }

    @PostMapping("/add")
    fun addStudent(): Int {
        val id = Random.nextInt()
        println("added student with id: $id")
        return id
    }

    @PutMapping("/updateSecondName/{newName}")
    fun updateSecondName(@PathVariable newName: String) {
        println("updated student's second name to $newName")
    }

    @DeleteMapping("/delete/{id}")
    fun deleteById(@PathVariable id: Int) {
        println("deleted student with id $id")
    }
}