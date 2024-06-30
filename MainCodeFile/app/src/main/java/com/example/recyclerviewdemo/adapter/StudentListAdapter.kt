package com.example.recyclerviewdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.databinding.SingleStudentItemLayoutBinding
import com.example.recyclerviewdemo.interfaces.StudentItemClickListener
import com.example.recyclerviewdemo.model.StudentModel

class StudentListAdapter(private var itemList: ArrayList<StudentModel>, private val listener: StudentItemClickListener) : RecyclerView.Adapter<StudentListAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_student_item_layout, parent, false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = holder.onBind(itemList[position])

    override fun getItemCount() = itemList.size

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = SingleStudentItemLayoutBinding.bind(itemView)

        fun onBind(currentItem: StudentModel) {
            binding.nameTextView.text = currentItem.studentName

            itemView.setOnClickListener {
                listener.onClickStudentItem(currentItem)
            }
        }
    }
}