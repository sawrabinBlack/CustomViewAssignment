package com.example.customviewassignment.mvp.presenters

import com.example.customviewassignment.delegates.ProfilesDelegate
import com.example.customviewassignment.mvp.views.CreateNewTaskView

interface CreateNewTaskPresenter:IBasePresenter, ProfilesDelegate {
    fun initView(view:CreateNewTaskView)
    fun onTapBack()
    fun onTapSave()
    fun onTapStartDate()
    fun onTapStopDate()

}