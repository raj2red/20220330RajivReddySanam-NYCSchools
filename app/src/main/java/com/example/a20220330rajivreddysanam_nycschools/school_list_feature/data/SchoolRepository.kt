package com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data

import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db.SchoolPojo

interface SchoolRepository {

    fun getSchools(): List<SchoolPojo>
}