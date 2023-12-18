package com.example.shemajamebeli5.sample_fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shemajamebeli5.R
import com.example.shemajamebeli5.databinding.VerticalRecyclerViewItemBinding
import com.example.shemajamebeli5.model.ActiveCourse

class SampleVerticalRecyclerAdapter :
    ListAdapter<ActiveCourse, SampleVerticalRecyclerAdapter.VerticalViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        val binding =
            VerticalRecyclerViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return VerticalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class VerticalViewHolder(private val binding: VerticalRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(course: ActiveCourse) {
            binding.apply {
                bookingTime.text = "booked for: ${course.bookingTime}"
                bookingItme2.text = "booked for: ${course.bookingTime}"

                Glide.with(binding.root)
                    .load(course.image)
                    .into(binding.icCourseIcon)

                val mainColor = Color.parseColor("#${course.mainColor}")
                val opacity =
                    course.backgroundColorPresent.toInt() * 255 / 100

                icCurrentProgress.setBackgroundColor(
                    Color.argb(
                        opacity,
                        Color.red(mainColor),
                        Color.green(mainColor),
                        Color.blue(mainColor)
                    )
                )

                val shapeDrawable = ContextCompat.getDrawable(root.context, R.drawable.rounded_corners_shape) as GradientDrawable
                shapeDrawable.setColor(Color.argb(
                    opacity,
                    Color.red(mainColor),
                    Color.green(mainColor),
                    Color.blue(mainColor)
                ))
                root.background = shapeDrawable

                icCourseIcon.setBackgroundColor(mainColor)

                bookingTime.setTextColor(
                    mainColor
                )

                bookingItme2.setTextColor(
                    mainColor
                )
            }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<ActiveCourse>() {
        override fun areItemsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
            return oldItem == newItem
        }
    }
}