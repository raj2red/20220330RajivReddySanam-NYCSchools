package com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db

import androidx.room.*

@Dao
interface SchoolDao {

    @Query("SELECT * FROM schoolpojo")
    suspend fun getSchoolList(): List<SchoolPojo>

    @Insert
    suspend fun insertAll(schoollist: List<SchoolPojo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertSchool(school: SchoolPojo)

    @Delete
    suspend fun deleteSchool(school: SchoolPojo)

    @Delete
    suspend fun deleteAll(schoollist: List<SchoolPojo>)

    @Query("SELECT * FROM schoolpojo WHERE id = :id")
    suspend fun getSchoolById(id: Int): SchoolPojo?
}