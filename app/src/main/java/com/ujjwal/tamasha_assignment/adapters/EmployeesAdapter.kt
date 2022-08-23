package com.ujjwal.tamasha_assignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ujjwal.tamasha_assignment.R
import com.ujjwal.tamasha_assignment.data.model.Employee
import kotlinx.android.synthetic.main.list_item_employee.view.*

class EmployeesAdapter(val employees: ArrayList<Employee>) :
    RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_employee, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(employees[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(employee: Employee) {
            itemView.tvUsername.text = employee.employee_name
            itemView.tvUserId.text = employee.id.toString()
            Glide.with(itemView.context)
                .load(employee.profile_image)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_employee).error(R.drawable.ic_employee)
                )
                .into(itemView.ivProfilePic)

            itemView.setOnClickListener {
                val tvSalary: TextView = itemView.tvSalary
                if (!tvSalary.isVisible) {
                    itemView.ivArrow.setImageResource(R.drawable.ic_up_arrow)
                    tvSalary.visibility = View.VISIBLE
                    val salaryText = "Employee Salary is ${employee.employee_salary}"
                    tvSalary.text = salaryText
                    tvSalary.startAnimation(
                        AnimationUtils.loadAnimation(
                            itemView.context,
                            android.R.anim.fade_in
                        )
                    )
                } else {
                    itemView.ivArrow.setImageResource(R.drawable.ic_down_arrow)
                    tvSalary.visibility = View.GONE
                    tvSalary.clearAnimation()
                }
            }
        }
    }

}