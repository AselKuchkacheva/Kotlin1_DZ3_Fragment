package com.example.kotlin1_dz3_fragment.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin1_dz3_fragment.R
import com.example.kotlin1_dz3_fragment.base.replaceFragmentBundle
import com.example.kotlin1_dz3_fragment.converter.CategoryConverter
import com.example.kotlin1_dz3_fragment.databinding.FragmentGalleryBinding
import com.example.kotlin1_dz3_fragment.model.Images
import com.example.kotlin1_dz3_fragment.ui.GalleryAdapter
import com.example.kotlin1_dz3_fragment.ui.galleryDetail.GalleryDetailFragment

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    private lateinit var imageAdapter: GalleryAdapter

    private var imageList = listOf(
        Images(imageID = R.drawable.fayer),
        Images(imageID = R.drawable.nolik),
        Images(imageID = R.drawable.igrek),
        Images(imageID = R.drawable.shpulya),
        Images(imageID = R.drawable.rubble),
        Images(imageID = R.drawable.simka)
    )

    private var index = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater)
        initRecycler()

        return binding.root
    }

    private fun initRecycler() {

        binding.rvGalleryActivity.apply {
            imageAdapter = GalleryAdapter()
            adapter = imageAdapter
        }

        binding.btnAddImage.setOnClickListener {
            if (index > 5) index = 0
            val imageModel = imageList[index]
            imageAdapter.addImageList(imageModel)
            index++
        }

        binding.btnSentGalleryActivity.setOnClickListener {
            val list = arrayListOf<Images>()
            for (model in imageAdapter.itemImages) {
                if (model.selected) {
                    list.add(model)
                }
            }

            val converter = CategoryConverter()
            val listFromStr = converter.fromListCategoryModel(list)

            val bundle = Bundle()
            bundle.putString("123", listFromStr)
            replaceFragmentBundle(activity, R.id.container_for_fragment, GalleryDetailFragment(), bundle, "" )

        }
    }
}