package com.ujjwal.tamasha_assignment.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ujjwal.tamasha_assignment.R

/**
 * This activity will host the EmployeesListFragment which will do the work.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}