package com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SchoolPojo::class], version = 1)
abstract class SchoolDatabase: RoomDatabase() {

    abstract val dao: SchoolDao
}