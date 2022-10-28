package com.example.customviewassignment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewassignment.delegates.AddNewTaskDelegate
import com.example.customviewassignment.delegates.ProfilesDelegate

class ProfileViewHolder(itemView: View,mDelegate: ProfilesDelegate) : BaseViewHolder(itemView) {

   init {
        itemView.setOnClickListener {
            mDelegate.onTapProfile()
        }


    }
}