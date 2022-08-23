package com.ujjwal.tamasha_assignment.data.api

import com.ujjwal.tamasha_assignment.data.model.EmployeeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EmployeesApiService {
    private val BASE_DEFAULT_URL = "https://mocki.io/"

    private val employeesApi = Retrofit.Builder()
        .baseUrl(BASE_DEFAULT_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EmployeesApi::class.java)

    suspend fun getEmployees(): EmployeeResponse {
        return employeesApi.getEmployees()
    }

}