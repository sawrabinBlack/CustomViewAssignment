package com.example.customviewassignment.mvp.presenters

import com.example.customviewassignment.delegates.ProfilesDelegate
import com.example.customviewassignment.mvp.views.MainView

interface MainPresenter:IBasePresenter ,ProfilesDelegate{

    fun iniView(view:MainView)
}