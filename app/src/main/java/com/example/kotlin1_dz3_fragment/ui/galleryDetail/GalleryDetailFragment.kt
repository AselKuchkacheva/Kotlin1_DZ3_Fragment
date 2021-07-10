package com.example.kotlin1_dz3_fragment.ui.galleryDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin1_dz3_fragment.converter.CategoryConverter
import com.example.kotlin1_dz3_fragment.databinding.FragmentGalleryDetailBinding
import com.example.kotlin1_dz3_fragment.model.Images
import com.example.kotlin1_dz3_fragment.ui.GalleryAdapter

class GalleryDetailFragment : Fragment() {

    private lateinit var binding: FragmentGalleryDetailBinding

    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGalleryDetailBinding.inflate(inflater)

        adapter = GalleryAdapter()

        initRv()

        return binding.root
    }

    private fun initRv() {

        binding.rvDetailGallery.adapter = adapter
        val converter = CategoryConverter()
        val strFromList = converter.fromString(arguments?.getString("123"))
        adapter.setList(strFromList as ArrayList<Images>)

    }
}