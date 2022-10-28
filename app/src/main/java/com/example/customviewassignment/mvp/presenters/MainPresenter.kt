package com.example.customviewassignment.mvp.presenters

import com.example.customviewassignment.delegates.AddNewTaskDelegate
import com.example.customviewassignment.delegates.ProfilesDelegate
import com.example.customviewassignment.mvp.views.MainView

interface MainPresenter:IBasePresenter ,ProfilesDelegate,AddNewTaskDelegate{

    fun iniView(view:MainView)
}