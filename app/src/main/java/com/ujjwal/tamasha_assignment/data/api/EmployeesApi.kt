package com.ujjwal.tamasha_assignment.data.api

import com.ujjwal.tamasha_assignment.data.model.EmployeeResponse
import retrofit2.http.GET

interface EmployeesApi {
    @GET("v1/61cf7d91-a7f8-405e-b505-67926b759d78")
    suspend fun getEmployees(): EmployeeResponse
}


