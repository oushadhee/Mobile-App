package com.example.dietplan.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "plans")
@Parcelize
data class Plan(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val adddate: String,
    val addmenu: String,

):Parcelable
