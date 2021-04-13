package com.example.facultyservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class FacultyController {
    @GetMapping("/faculty/{id}")
    fun getFacultyForStudent(@PathVariable id: Int): String {
        println("found faculty for student with id $id")
        return "random_faculty_#${Random.nextInt()}"
    }
}