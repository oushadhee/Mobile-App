package com.example.dietplan.database

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.dietplan.model.Plan

@Dao
interface PlanDao {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun inserPlan(plan: Plan)

   @Update
   suspend fun updatePlan(plan: Plan)

    @Delete
    suspend fun deletePlan(plan: Plan)

    @Query("SELECT * FROM PLANS ORDER BY id DESC")
    fun getAllPlanes(): LiveData<List<Note>>

    @Query("SELECT * FROM PLANS WHERE adddate " +
            "lIKE :query OR addmenu LIKE :query")
    fun searchPlan(query: String?): LiveData<List<Note>>
}