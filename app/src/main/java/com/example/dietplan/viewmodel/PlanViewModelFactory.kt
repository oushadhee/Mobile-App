package com.example.dietplan.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dietplan.repository.PlanRepository

class PlanViewModelFactory(val app: Application, private val planRepository:PlanRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlanViewModel(app,planRepository) as T
    }
}