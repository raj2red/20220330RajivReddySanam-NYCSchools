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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val schoolViewModel: SchoolListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        schoolViewModel.events.observe(this){

            when(it){
                APIEvents.INPROGRESS -> {
                    details_progress.visibility= View.VISIBLE
                    details_layout.visibility= View.GONE
                }
                APIEvents.FAILED -> {
                    details_progress.visibility= View.VISIBLE
                    details_layout.visibility= View.GONE
                }
                APIEvents.SUCCESSFUL -> {
                    details_progress.visibility= View.GONE
                    details_layout.visibility= View.VISIBLE
                    schoolViewModel.updateDetailsView()
                }
            }
        }



        schoolViewModel.satLiveData.observe(this) {
            Picasso.get().load("https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png").into(mImageViewCardViewItem)
            mSchoolName.text=it.schoolName.toString()
            sat_writing_avg_score.text=it.satWritingAvgScore.toString()
            reading_avg_score.text=it.satCriticalReadingAvgScore.toString()
            math_avg_score.text=it.satMathAvgScore.toString()
        }

        intent.getStringExtra("name")?.let { schoolViewModel.fetchSATData(it) }
    }
}