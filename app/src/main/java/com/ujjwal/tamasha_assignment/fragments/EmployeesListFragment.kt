package com.ujjwal.tamasha_assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ujjwal.tamasha_assignment.R
import com.ujjwal.tamasha_assignment.adapters.EmployeesAdapter
import com.ujjwal.tamasha_assignment.data.model.Employee
import com.ujjwal.tamasha_assignment.data.viewmodels.EmployeesViewModel
import com.ujjwal.tamasha_assignment.utils.Status
import kotlinx.android.synthetic.main.fragment_main.view.*

class EmployeesListFragment : Fragment() {

    private lateinit var viewModel: EmployeesViewModel
    private val adapter = EmployeesAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[EmployeesViewModel::class.java]
        view.rvEmployees.adapter = adapter
        view.rvEmployees.layoutManager = LinearLayoutManager(requireContext())
        observeEmployees()
        getEmployees()
    }

    private fun observeEmployees() {
        viewModel.employeesLiveData.observe(this.viewLifecycleOwner) { suggestedUsersResource ->
            when (suggestedUsersResource.status) {
                Status.SUCCESS -> {
                    val employees: List<Employee>? = suggestedUsersResource.data
                    if (employees != null) {
                        for (i in employees.indices) {
                            val employee: Employee = employees[i]
                            adapter.employees.add(employee)
                            adapter.notifyItemInserted(i)
                        }
                    }
                }
                Status.ERROR -> {
                    Toast.makeText(context, "Some Error Occurred", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    // loading progress bar can be shown here
                }
            }
        }
    }

    private fun getEmployees() {
        viewModel.getEmployees()
    }
}