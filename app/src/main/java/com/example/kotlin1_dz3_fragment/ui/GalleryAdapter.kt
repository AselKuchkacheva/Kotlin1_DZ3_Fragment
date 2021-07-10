package com.example.kotlin1_dz3_fragment.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin1_dz3_fragment.R
import com.example.kotlin1_dz3_fragment.databinding.ItemGalleryBinding
import com.example.kotlin1_dz3_fragment.model.Images

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    var itemImages = ArrayList<Images>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(
            ItemGalleryBinding.inflate(
                LayoutInflater
                    .from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(itemImages[position])
    }

    override fun getItemCount(): Int {
        return itemImages.size
    }

    public fun setList(list: ArrayList<Images>) {
        itemImages = list
        notifyDataSetChanged()
    }

    fun addImageList(images: Images) {
        itemImages.add(images)
        notifyDataSetChanged()
    }

    class GalleryViewHolder(private val binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(images: Images) {

            binding.ivItemImage.setOnLongClickListener {

                images.selected = !images.selected
                if (images.selected) {
                    binding.transView.setBackgroundColor(R.color.trans_black)
                } else {
                    binding.transView.setBackgroundColor(Color.TRANSPARENT)
                }
                true
            }

            Glide.with(itemView.context)
                .load(images.imageID)
                .into(binding.ivItemImage)
        }
    }
}