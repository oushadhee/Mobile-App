package com.example.dietplan.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.dietplan.model.Plan
import com.example.dietplan.repository.PlanRepository
import kotlinx.coroutines.launch

class PlanViewModel(app: Application,private val planRepository: PlanRepository): AndroidViewModel(app) {

    fun addPlan(plan: Plan) =
        viewModelScope.launch {
            planRepository.insertPlan(plan)
        }

    fun deletePlan(plan: Plan) =
        viewModelScope.launch {
            planRepository.deletePlan(plan)
        }

    fun updatePlan(plan: Plan) =
        viewModelScope.launch {
            planRepository.updatePlan(plan)
        }

    fun getAllPlans() = planRepository.getAllPlans()

    fun searchPlan(query: String?) =
        planRepository.searchPlan(query)
}