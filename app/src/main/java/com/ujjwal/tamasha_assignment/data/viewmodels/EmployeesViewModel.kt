package com.ujjwal.tamasha_assignment.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ujjwal.tamasha_assignment.data.model.Employee
import com.ujjwal.tamasha_assignment.data.repository.EmployeesRepository
import com.ujjwal.tamasha_assignment.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeesViewModel : ViewModel() {

    private val employeesRepository = EmployeesRepository()

    private val employeesMLiveData: MutableLiveData<Resource<List<Employee>>> = MutableLiveData()
    val employeesLiveData: LiveData<Resource<List<Employee>>> = employeesMLiveData

    fun getEmployees() {
        viewModelScope.launch(Dispatchers.IO) {
            employeesMLiveData.postValue(Resource.loading(data = null))
            try {
                employeesMLiveData.postValue(
                    Resource.success(
                        data = employeesRepository.getEmployees()
                    )
                )
            } catch (exception: Exception) {
                employeesMLiveData.postValue(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!"
                    )
                )
            }
        }
    }
}