package com.ujjwal.tamasha_assignment.data.model

data class EmployeeResponse(
    val `data`: List<Employee>,
    val message: String,
    val status: String
)

data class Employee(
    val employee_age: Int,
    val employee_name: String,
    val employee_salary: Int,
    val id: Int,
    val profile_image: String
)