package com.example.customviewassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewassignment.R
import com.example.customviewassignment.delegates.ProfilesDelegate
import com.example.customviewassignment.views.viewholders.AddTaskViewHolder
import com.example.customviewassignment.views.viewholders.BaseViewHolder
import com.example.customviewassignment.views.viewholders.ProfileViewHolder

class ProfileListAdapter (val mProfilesDelegate: ProfilesDelegate): RecyclerView.Adapter<BaseViewHolder>() {
    val VIEW_TYPE_PROFILE = 2244
    val VIEW_TYPE_ADD = 1122
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        when (viewType) {
            VIEW_TYPE_PROFILE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_profile, parent, false)
                return ProfileViewHolder(view,mProfilesDelegate)
            }
            VIEW_TYPE_ADD -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_add_profile, parent, false)
                return AddTaskViewHolder(view,mProfilesDelegate)
            }else->{
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_profile, parent, false)
            return ProfileViewHolder(view,mProfilesDelegate)
            }
        }

    }


    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        when (position) {
            3 -> {
                return VIEW_TYPE_ADD
            }
            else -> return VIEW_TYPE_PROFILE
        }
    }
}