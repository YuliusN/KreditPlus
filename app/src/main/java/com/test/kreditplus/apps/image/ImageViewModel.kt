package com.test.kreditplus.apps.image

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ImageViewModel (private val imageRepo: ImageRepo) : ViewModel(){
    fun getImages() = imageRepo.getImages()
    fun setImages(listImg:ArrayList<Image>) = imageRepo.setImage(listImg)
}