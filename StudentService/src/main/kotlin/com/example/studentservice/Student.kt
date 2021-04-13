package com.example.studentservice

data class Student(
    val id: Int,
    val name: String,
    val secondName: String,
    val faculty: String = "maths"
)