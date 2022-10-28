package com.example.customviewassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewassignment.R
import com.example.customviewassignment.delegates.ProfilesDelegate
import com.example.customviewassignment.views.viewholders.TaskListWithDateViewHolder
import com.example.customviewassignment.views.viewholders.TaskViewViewHolder

class TaskListWithDataAdapter(private val mDelegate: ProfilesDelegate) : RecyclerView.Adapter<TaskListWithDateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListWithDateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_task_with_date, parent, false)
        return TaskListWithDateViewHolder(view,mDelegate)
    }


    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: TaskListWithDateViewHolder, position: Int) {

    }
}