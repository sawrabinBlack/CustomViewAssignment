package com.example.customviewassignment.views.viewholders

import android.view.View
import com.example.customviewassignment.delegates.ProfilesDelegate

class ProfileViewHolder(itemView: View,mDelegate: ProfilesDelegate) : BaseViewHolder(itemView) {

   init {
        itemView.setOnClickListener {
            mDelegate.onTapProfile()
        }


    }
}