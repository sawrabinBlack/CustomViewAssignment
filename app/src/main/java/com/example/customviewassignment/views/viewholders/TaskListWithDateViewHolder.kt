package com.example.customviewassignment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.customviewassignment.adapters.TaskListAdapter
import com.example.customviewassignment.delegates.ProfilesDelegate
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.view_holder_task_with_date.view.*

class TaskListWithDateViewHolder(itemView: View,private val mDelegate: ProfilesDelegate) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.rvTaskWithData.adapter = TaskListAdapter(false,mDelegate)
        itemView.rvTaskWithData.layoutManager =
            LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
    }
}