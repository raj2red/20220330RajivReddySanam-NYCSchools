package com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SchoolPojo(
    val school_name: String,
    val advancedplacement_courses: String?,
    val diplomaendorsements: String?,
    val language_classes: String?,
    val imageURL: String?,
    @PrimaryKey val id: Int? = null
)
