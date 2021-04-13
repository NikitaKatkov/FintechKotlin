package com.example.studentservice

import com.example.studentservice.FacultyServiceInteraction.getFacultyForStudent
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
@RequestMapping("/students")
class StudentController {
    @ApiOperation("Returns all registered students")
    @GetMapping("/all")
    fun getStudents(): List<Student> {
        println("found all students")
        return listOf(Student(Random.nextInt(), "Nikita", "Katkov"))
    }

    @ApiOperation("Returns registered student with given id if it exists")
    @ApiResponses(
        ApiResponse(code = 200, message = "Ok, student exists"),
        ApiResponse(code = 404, message = "Student with given id doesn't exist")
    )
    @GetMapping("/{id}")
    fun getStudentById(
        @ApiParam("id of a particular student to search for") @PathVariable id: Int
    ): Student {
        println("found student with id: $id")
        val facultyForStudent = getFacultyForStudent(id).orEmpty()
        return Student(id, "Nikita", "Katkov", facultyForStudent)
    }

    @ApiOperation("")
    @PostMapping("/add")
    fun addStudent(): Int {
        val id = Random.nextInt()
        println("added student with id: $id")
        return id
    }

    @PutMapping("/updateSecondName/{newName}")
    fun updateSecondName(
        @ApiParam("updated second name of a particular student") @PathVariable newName: String
    ) {
        println("updated student's second name to $newName")
    }

    @DeleteMapping("/delete/{id}")
    fun deleteById(
        @ApiParam("id of a particular student to delete") @PathVariable id: Int
    ) {
        println("deleted student with id $id")
    }
}