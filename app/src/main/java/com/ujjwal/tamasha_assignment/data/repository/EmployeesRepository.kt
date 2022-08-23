package com.ujjwal.tamasha_assignment.data.repository

import com.ujjwal.tamasha_assignment.data.api.EmployeesApiService
import com.ujjwal.tamasha_assignment.data.model.Employee

class EmployeesRepository {

    private val employeesApi = EmployeesApiService()

    suspend fun getEmployees(
    ): List<Employee> {
        return employeesApi.getEmployees(
        ).data
    }
}
