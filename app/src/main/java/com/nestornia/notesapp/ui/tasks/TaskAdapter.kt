package com.nestornia.notesapp.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nestornia.notesapp.data.Task
import com.nestornia.notesapp.databinding.ItemTaskBinding

class TaskAdapter : ListAdapter<Task, TaskAdapter.TasksViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class TasksViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(task : Task) {
            binding.apply {
                checkboxCompleted.isChecked = task.completed
                tvNameTask.text = task.taskName
                tvNameTask.paint.isStrikeThruText = task.completed
                labelPriority.isVisible =  task.important
            }
        }
    }

    class DiffCallback :  DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Task, newItem: Task) =
            oldItem == newItem

    }
}