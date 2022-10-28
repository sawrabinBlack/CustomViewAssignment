package com.example.customviewassignment.mvp.presenters

import androidx.lifecycle.LifecycleOwner

interface IBasePresenter {
fun onUiReady(owner:LifecycleOwner)
}