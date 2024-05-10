package com.example.dietplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.dietplan.database.PlanDatabase
import com.example.dietplan.model.Plan
import com.example.dietplan.repository.PlanRepository
import com.example.dietplan.viewmodel.PlanViewModel
import com.example.dietplan.viewmodel.PlanViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var planViewModel: PlanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }
    private fun setupViewModel(){
        val planRepository = PlanRepository(PlanDatabase(this))
        val viewModelProviderFactory = PlanViewModelFactory(application,planRepository)
        planViewModel = ViewModelProvider(this,viewModelProviderFactory)[PlanViewModel::class.java]
    }
}