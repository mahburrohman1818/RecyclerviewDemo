package com.example.recyclerviewdemo.interfaces

import com.example.recyclerviewdemo.model.StudentModel

interface StudentItemClickListener {
    fun onClickStudentItem(studentModel: StudentModel)
}