package com.example.customviewassignment.views.viewholders

import android.view.View
import com.example.customviewassignment.delegates.ProfilesDelegate

class AddTaskViewHolder(itemView: View, private val mDelegate: ProfilesDelegate) : BaseViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            mDelegate.onTapAdd()
        }
    }
}