package com.example.kotlin1_dz3_fragment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin1_dz3_fragment.R
import com.example.kotlin1_dz3_fragment.base.replaceFragment2
import com.example.kotlin1_dz3_fragment.ui.gallery.GalleryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment2(this, R.id.container_for_fragment, GalleryFragment(), "GalleryFragment")
    }
}