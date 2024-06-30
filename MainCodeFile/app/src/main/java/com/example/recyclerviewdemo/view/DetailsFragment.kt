package com.example.recyclerviewdemo.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewdemo.R
import com.example.recyclerviewdemo.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        val studentName = arguments?.getString("STUDENT_NAME", "name")
        val mobileNumber = arguments?.getString("MOBILE_NUMBER", "0000000000")

        binding.detailsTextView.text = "$studentName \n$mobileNumber"

        return binding.root
    }
}