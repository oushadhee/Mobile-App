package com.example.dietplan.repository

import androidx.room.Query
import com.example.dietplan.database.PlanDatabase
import com.example.dietplan.model.Plan

class PlanRepository (private val db: PlanDatabase){

    suspend fun insertPlan(plan: Plan) = db.getPlanDao().inserPlan(plan)
    suspend fun deletePlan(plan: Plan) = db.getPlanDao().deletePlan(plan)
    suspend fun updatePlan(plan: Plan) = db.getPlanDao().updatePlan(plan)

    fun getAllPlans() =db.getPlanDao().getAllPlanes()
    fun searchPlan(query: String?) = db.getPlanDao().searchPlan(query)
}