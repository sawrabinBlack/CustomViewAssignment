package com.example.customviewassignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.customviewassignment.mvp.views.MainView

class MainPresenterImpl : MainPresenter, ViewModel() {
    var mMainView: MainView? = null
    override fun iniView(view: MainView) {
        mMainView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapProfile() {
        mMainView?.navigateToProfile()
    }

    override fun onTapAdd() {
        mMainView?.navigateToCreateNewTask()
    }
}