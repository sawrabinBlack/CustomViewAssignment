package com.example.customviewassignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.example.customviewassignment.mvp.views.CreateNewTaskView

class CreateNewTaskPresenterImpl : ViewModel(), CreateNewTaskPresenter {
    lateinit var mView: CreateNewTaskView
    override fun initView(view: CreateNewTaskView) {
        mView = view
    }

    override fun onTapBack() {
        mView.navigateToMain()
    }

    override fun onTapSave() {
        mView.navigateToMain()
    }

    override fun onTapStartDate() {
        mView.pickDateForStartDate()

    }

    override fun onTapStopDate() {
        mView.pickDateForEndDate()
    }


    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapProfile() {
        mView.navigateToProfile()
    }

    override fun onTapAdd() {

    }
}