package com.example.shemajamebeli5.sample_fragment

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.R
import com.example.shemajamebeli5.databinding.HorizontalRecyclerViewItemBinding
import com.example.shemajamebeli5.model.NewCourse

class SampleHorizontalRecyclerAdapter :
    ListAdapter<NewCourse, SampleHorizontalRecyclerAdapter.HorizontalViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val binding =
            HorizontalRecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HorizontalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class HorizontalViewHolder(private val binding: HorizontalRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: NewCourse) {
            binding.apply {
                title.text = course.title
                question.text = course.question
                time.text = ("${course.duration} min")

                root.setBackgroundColor(Color.parseColor("#${course.mainColor}"))
                val shapeDrawable = ContextCompat.getDrawable(root.context, R.drawable.rounded_corners_shape) as GradientDrawable
                shapeDrawable.setColor(Color.parseColor("#${course.mainColor}"))
                root.background = shapeDrawable
            }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<NewCourse>() {
        override fun areItemsTheSame(oldItem: NewCourse, newItem: NewCourse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewCourse, newItem: NewCourse): Boolean {
            return oldItem == newItem
        }
    }
}