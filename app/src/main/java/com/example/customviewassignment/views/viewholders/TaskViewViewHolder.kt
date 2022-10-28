package com.example.customviewassignment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewassignment.delegates.ProfilesDelegate
import kotlinx.android.synthetic.main.view_holder_task.view.*

class TaskViewViewHolder(
    itemView: View,
    private val status: Boolean,
    val mDelegate: ProfilesDelegate
) :
    RecyclerView.ViewHolder(itemView) {

    init {

        if (status) {
            itemView.ivStatus.visibility = View.GONE
            itemView.viewStatus.visibility = View.GONE
        } else {
            itemView.ivStatus.visibility = View.VISIBLE
            itemView.viewStatus.visibility = View.VISIBLE
        }
        itemView.ivProfileTask.setOnClickListener {
            mDelegate.onTapProfile()
        }
    }
}