package com.test.kreditplus.apps.image

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ImageFactory (private val imageRepo: ImageRepo) : ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageViewModel(imageRepo) as T
    }
}