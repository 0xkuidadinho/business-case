package com.android.support.exercise.bd.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int?=null,
    val name: String,
    val image: String
)

