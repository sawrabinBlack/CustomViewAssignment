package com.example.customviewassignment.activities

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviewassignment.R
import com.example.customviewassignment.adapters.OverLapDecoration
import com.example.customviewassignment.adapters.ProfileListAdapter
import com.example.customviewassignment.adapters.TaskCategoryAdapter
import com.example.customviewassignment.adapters.TaskListAdapter
import com.example.customviewassignment.mvp.presenters.CreateNewTaskPresenter
import com.example.customviewassignment.mvp.presenters.CreateNewTaskPresenterImpl
import com.example.customviewassignment.mvp.views.CreateNewTaskView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_create_new_task.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet_profile.*
import java.util.*

class CreateNewTaskActivity : AppCompatActivity(), CreateNewTaskView {
    val tabList = listOf("Project Tasks", "Contacts", "About you", "Finished")
    lateinit var mProfileListAdapter: ProfileListAdapter
    lateinit var mTaskCategoryAdapter: TaskCategoryAdapter
    lateinit var mPresenter: CreateNewTaskPresenter
    lateinit var mProfileTasksAdapter:TaskListAdapter
    val calender = Calendar.getInstance()
    val day = calender[Calendar.DAY_OF_MONTH]
    val month = calender[Calendar.MONTH]
    val year = calender[Calendar.YEAR]

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CreateNewTaskActivity::class.java)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_task)
        setUpPresenter()
        setUpRecyclerViews()
        setUpTabLayout()
        setUpOnClickListener()
        setUpBottomSheet()
    }

    private fun setUpBottomSheet() {
        val sheet = BottomSheetBehavior.from(botSheetAddNewTask)
        btnCloseBtSheet.setOnClickListener {
            sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[CreateNewTaskPresenterImpl::class.java]
        mPresenter.initView(this)
    }


    private fun setUpRecyclerViews() {
        mProfileListAdapter = ProfileListAdapter(mPresenter)
        rvAssignee.adapter = mProfileListAdapter
        rvAssignee.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvAssignee.addItemDecoration(OverLapDecoration())
        mTaskCategoryAdapter = TaskCategoryAdapter()
        rvTaskCategory.adapter = mTaskCategoryAdapter
        rvTaskCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mProfileTasksAdapter = TaskListAdapter(true, mPresenter)
        rvProfileTasks.adapter = mProfileTasksAdapter
        rvProfileTasks.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpOnClickListener() {

        tvStartDate.setOnClickListener {
            mPresenter.onTapStartDate()

        }
        tvTaskEndDate.setOnClickListener {

            mPresenter.onTapStopDate()

        }

        ivBackButtonNewTask.setOnClickListener {
            mPresenter.onTapBack()
        }
        tvSave.setOnClickListener {
            mPresenter.onTapBack()
        }

    }

    override fun pickDateForStartDate() {
        //date picker dialog
        val picker = DatePickerDialog(
            this, { view, year, monthOfYear, dayOfMonth ->
                //logic Can be Written here
                tvStartDate.text = ("$dayOfMonth/${monthOfYear + 1}/$year")
            }, year, month, day

        )

        picker.show()
    }

    override fun pickDateForEndDate() {
        val picker = DatePickerDialog(
            this, { view, year, monthOfYear, dayOfMonth ->
                //logic Can be Written here
                tvTaskEndDate.text = ("$dayOfMonth/${monthOfYear + 1}/$year")
            }, year, month, day

        )

        picker.show()
    }

    override fun navigateToMain() {
        finish()
    }

    override fun navigateToProfile() {
        val sheet = BottomSheetBehavior.from(botSheetAddNewTask)
        when {
            sheet.state != BottomSheetBehavior.STATE_EXPANDED -> {
                sheet.state = BottomSheetBehavior.STATE_EXPANDED
            }
            else -> sheet.state = BottomSheetBehavior.STATE_COLLAPSED
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
}