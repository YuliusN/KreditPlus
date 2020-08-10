package com.test.kreditplus.apps.image

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ImageDao {
    private val imageList= mutableListOf<Image>()
    private val images = MutableLiveData<List<Image>>()

    init {
        images.value = imageList
    }

    fun getImage() = images as LiveData<List<Image>>

    fun setImage(list:ArrayList<Image>){
        imageList.clear()
        list.forEach{item ->
            if (item != null){
                imageList.add(item)
            }
        }
        images.value = imageList
    }
}