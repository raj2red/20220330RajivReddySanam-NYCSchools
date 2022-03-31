package com.example.a20220330rajivreddysanam_nycschools.school_list_feature.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a20220330rajivreddysanam_nycschools.R
import com.example.a20220330rajivreddysanam_nycschools.school_list_feature.data.db.SchoolPojo
import com.squareup.picasso.Picasso


class SchoolCustomAdapter(private val mList: List<SchoolPojo>, private val mContext: Context) :
    RecyclerView.Adapter<SchoolCustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val items = mList[position]

        Picasso.get().load(mList[position].imageURL).into(holder.imageView)
        holder.mSchoolName.text = items.school_name
        holder.mSchoolCourse.text = items.advancedplacement_courses
        holder.mSchoolLanguages.text = items.language_classes
        holder.itemView.setOnClickListener {
            val i = Intent(mContext, DetailsActivity::class.java)
            i.putExtra("name", items.school_name)
            mContext.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.mImageViewCardViewItem)
        val mSchoolName: TextView = itemView.findViewById(R.id.mSchoolName)
        val mSchoolCourse: TextView = itemView.findViewById(R.id.mSchoolCourse)
        val mSchoolLanguages: TextView = itemView.findViewById(R.id.mSchoolLanguages)
    }

}