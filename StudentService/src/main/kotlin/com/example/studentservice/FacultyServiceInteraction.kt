package com.example.studentservice

import org.springframework.web.client.RestTemplate

object FacultyServiceInteraction {
    private val template = RestTemplate()

    fun getFacultyForStudent(studentId: Int): String? {
        return template.getForObject("http://localhost:8081/faculty/$studentId", String::class.java)
    }
}