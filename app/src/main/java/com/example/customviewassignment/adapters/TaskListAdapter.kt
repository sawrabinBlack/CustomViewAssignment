package com.example.customviewassignment.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewassignment.R
import com.example.customviewassignment.delegates.ProfilesDelegate
import com.example.customviewassignment.views.viewholders.TaskViewViewHolder

class TaskListAdapter(private val status:Boolean,private val mDelegate: ProfilesDelegate): RecyclerView.Adapter<TaskViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.view_holder_task,parent,false)
        return TaskViewViewHolder(view,status,mDelegate)
    }

    override fun onBindViewHolder(holder: TaskViewViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 2
    }


}