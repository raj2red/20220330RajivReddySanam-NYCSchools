package com.example.a20220330rajivreddysanam_nycschools.school_list_feature.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a20220330rajivreddysanam_nycschools.R
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.viewmodel.SchoolListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import androidx.activity.viewModels
import com.example.a20220330rajivreddysanam_nycschools.util.network.APIEvents


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val schoolViewModel: SchoolListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        schoolViewModel.events.observe(this){

            when(it){
                APIEvents.INPROGRESS -> {
                    progress.visibility= View.VISIBLE
                    mRecyclerView.visibility= View.GONE
                }
                APIEvents.FAILED -> {
                    progress.visibility= View.VISIBLE
                    mRecyclerView.visibility= View.GONE
                }
                APIEvents.SUCCESSFUL -> {
                    progress.visibility= View.GONE
                    mRecyclerView.visibility= View.VISIBLE
                    schoolViewModel.updateRecyclerView()
                }
            }

        }



        schoolViewModel.data.observe(this) {

            val customAdapter = SchoolCustomAdapter(it,this@MainActivity)
            mRecyclerView.layoutManager = LinearLayoutManager(this)
            mRecyclerView.adapter = customAdapter

        }

        schoolViewModel.fetchSchoolData()



    }
}