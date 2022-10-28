package com.example.customviewassignment.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewassignment.R
import com.example.customviewassignment.adapters.OverLapDecoration
import com.example.customviewassignment.adapters.ProfileListAdapter
import com.example.customviewassignment.adapters.TaskListAdapter
import com.example.customviewassignment.adapters.TaskListWithDataAdapter
import com.example.customviewassignment.mvp.presenters.MainPresenter
import com.example.customviewassignment.mvp.presenters.MainPresenterImpl
import com.example.customviewassignment.mvp.views.MainView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_profile.*

class MainActivity : AppCompatActivity(), MainView {
    val tabList = listOf("Project Tasks", "Contacts", "About you", "Finished")
    lateinit var mProfileAdapter: ProfileListAdapter
    lateinit var mTaskListAdapter: TaskListWithDataAdapter
    lateinit var mProfileTasksAdapter: TaskListAdapter
    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()
        setUpBottomSheet()
        setUpRecyclerViews()


        setUpTabLayout()

    }

    private fun setUpBottomSheet() {
        val sheet = BottomSheetBehavior.from(bottomSheetProfile)
        btnCloseBtSheet.setOnClickListener {
            sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    private fun setUpTabLayout() {
        tabList.forEach {
            tabLayoutProfile.newTab().apply {
                text = it
                tabLayoutProfile.addTab(this)
            }
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mPresenter.iniView(this)
    }

    private fun setUpRecyclerViews() {
        //Profile RecyclerView
        mProfileAdapter = ProfileListAdapter(mPresenter)
        rvProfile.adapter = mProfileAdapter
        rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvProfile.addItemDecoration(OverLapDecoration())

//Task List Recycler View
        mTaskListAdapter = TaskListWithDataAdapter(mPresenter)
        rvTaskList.adapter = mTaskListAdapter
        rvTaskList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Task List Adapter Setup For Task View
        mProfileTasksAdapter = TaskListAdapter(true, mPresenter)
        rvProfileTasks.adapter = mProfileTasksAdapter
        rvProfileTasks.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun navigateToCreateNewTask() {
        startActivity(CreateNewTaskActivity.newIntent(this))
    }

    override fun navigateToProfile() {

        val sheet = BottomSheetBehavior.from(bottomSheetProfile)
        when {
            sheet.state != BottomSheetBehavior.STATE_EXPANDED -> {
                sheet.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else -> sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}