package com.example.recyclerviewdemo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.adapter.StudentListAdapter
import com.example.recyclerviewdemo.databinding.FragmentHomeBinding
import com.example.recyclerviewdemo.interfaces.StudentItemClickListener
import com.example.recyclerviewdemo.model.StudentModel


class HomeFragment : Fragment(), StudentItemClickListener {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)


        val studentList = ArrayList<StudentModel>()
        studentList.add(StudentModel("Habib", "0170000"))
        studentList.add(StudentModel("Ajij", "0180000"))
        studentList.add(StudentModel("Mahtab", "0190000"))
        studentList.add(StudentModel("Nazmul", "0150000"))

        binding.studentListRecyclerview.adapter = StudentListAdapter(studentList, this)


        return binding.root
    }

    override fun onClickStudentItem(studentModel: StudentModel) {
        val bundle = bundleOf(
            "STUDENT_NAME" to studentModel.studentName,
            "MOBILE_NUMBER" to studentModel.mobileNumber
        )

        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }

}