package com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data

import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db.SchoolDatabase
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db.SchoolPojo

class SchoolRepositoryImpl(db: SchoolDatabase) : SchoolRepository {
    override fun getSchools() = listOf(
        SchoolPojo(
            school_name = "Young Women's Leadership School, Queens (TYWLS)",
            advancedplacement_courses = "AP Calculus, AP English, AP Environmental Science, AP US History",
            language_classes = "Arabic, French, Greek, Italian, Japanese, Korean, Spanish",
            diplomaendorsements = "Math, Science, CTE",
            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
        ),
//        SchoolPojo(
//            school_name = "World View High School",
//            advancedplacement_courses = "AP Calculus, AP English, AP Environmental Science, AP US History",
//            language_classes = "Arabic, French, Greek, Italian, Japanese, Korean, Spanish",
//            diplomaendorsements = "Math, Science, CTE",
//            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
//        ),
//        SchoolPojo(
//            school_name = "Williamsburg Preparatory School",
//            advancedplacement_courses = "AP Calculus, AP English, AP Environmental Science, AP US History",
//            language_classes = "Arabic, French, Greek, Italian, Japanese, Korean, Spanish",
//            diplomaendorsements = "Math, Science, CTE",
//            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
//        ),
//        SchoolPojo(
//            school_name = "School 4",
//            advancedplacement_courses = "AP Calculus, AP English, AP Environmental Science, AP US History",
//            language_classes = "Arabic, French, Greek, Italian, Japanese, Korean, Spanish",
//            diplomaendorsements = "Math, Science, CTE",
//            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
//        ),
//        SchoolPojo(
//            school_name = "School 5",
//            advancedplacement_courses = "AP Calculus, AP English, AP Environmental Science, AP US History",
//            language_classes = "Arabic, French, Greek, Italian, Japanese, Korean, Spanish",
//            diplomaendorsements = "Math, Science, CTE",
//            imageURL = "https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"
//        )
    )
}