package com.example.a20220330rajivreddysanam_nycschools.school_list_feature.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db.SchoolPojo
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db.SchoolDatabase
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.SchoolRepository
import com.example.a20220330rajivreddysanam_nycschools.util.network.*
import com.example.a20220330rajivreddysanam_nycschools.util.network.data.SchoolAPIResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel @Inject constructor(
    private val db: SchoolDatabase,
    private val repo: SchoolRepository,
    private val apiRepository: APIRepository
): ViewModel() {


    private var listData=MutableLiveData<List<SchoolPojo>>()
    private var  satData = MutableLiveData<SATResponseItem>()

    var events=MutableLiveData<APIEvents>()
    var  apiData = mutableListOf<SchoolPojo>()
    var  tempSat = SATResponseItem()

    val data: LiveData<List<SchoolPojo>> get() = listData
    val satLiveData: LiveData<SATResponseItem> get() = satData


    fun fetchSchoolData() = viewModelScope.launch(Dispatchers.IO) {


        apiRepository.getSchoolsResponse().enqueue(object : Callback<List<SchoolAPIResponseItem>> {
            override fun onFailure(call: Call<List<SchoolAPIResponseItem>>?, t: Throwable?) {
                Log.e("retrofit", "call onFailure")
                events.postValue(APIEvents.FAILED)
            }

            override fun onResponse(call: Call<List<SchoolAPIResponseItem>>?, response: Response<List<SchoolAPIResponseItem>>?) {
                Log.e("retrofit", "call onResponse"+response!!.body().toString())
                val listResponse=response.body()

                apiData.clear()
                listResponse?.forEach {p ->
                    apiData.add(SchoolPojo(p.schoolName,p.advancedplacementCourses,p.diplomaendorsements,p.languageClasses,"https://cdn4.iconfinder.com/data/icons/bettericons/354/github-512.png"))
                    Log.e("retrofit forEach ", p.schoolName)
                }
                events.postValue(APIEvents.SUCCESSFUL)

            }

        })

    }


    fun fetchSATData(str:String) = viewModelScope.launch(Dispatchers.IO) {



        apiRepository.getSATResponse().enqueue(object : Callback<List<SATResponseItem>> {
            override fun onFailure(call: Call<List<SATResponseItem>>?, t: Throwable?) {
                Log.e("retrofit", "call onFailure")
                events.postValue(APIEvents.FAILED)
            }

            override fun onResponse(call: Call<List<SATResponseItem>>?, response: Response<List<SATResponseItem>>?) {
                Log.e("retrofit", "call onResponse"+response!!.body().toString())
                val listResponse=response.body()

                listResponse?.forEach {p ->
                    if(str.lowercase()== p.schoolName?.lowercase() ){
                        tempSat=p
                    }
                }
                events.postValue(APIEvents.SUCCESSFUL)

            }

        })

    }


    fun updateRecyclerView(){
        viewModelScope.launch(Dispatchers.IO) {
            db.dao.deleteAll(db.dao.getSchoolList())
            apiData.let { db.dao.insertAll(it) }
            listData.postValue(db.dao.getSchoolList())
        }
    }


    fun updateDetailsView(){
        satData.value=tempSat
    }


}