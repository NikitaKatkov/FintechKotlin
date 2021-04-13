package com.example.studentservice

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel
data class Student(
    @ApiModelProperty("Unique identifier of a particular student")
    val id: Int,
    @ApiModelProperty("Name of a particular student")
    val name: String,
    @ApiModelProperty("Second name of a particular student")
    val secondName: String,
    @ApiModelProperty("Faculty a particular student studies in")
    val faculty: String = "maths"
)