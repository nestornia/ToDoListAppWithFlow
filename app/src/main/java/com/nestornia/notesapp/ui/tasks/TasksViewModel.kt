package com.nestornia.notesapp.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.nestornia.notesapp.data.TaskDao

class TasksViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao
) : ViewModel() {
}