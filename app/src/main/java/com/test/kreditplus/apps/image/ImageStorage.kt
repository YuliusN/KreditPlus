package com.test.kreditplus.apps.image

class ImageStorage private constructor(){
    val imageDao = ImageDao()

    companion object{

        @Volatile private var instance: ImageStorage? = null

        fun getInstance() =
            instance ?: synchronized(this){
                instance ?: ImageStorage().also { instance = it }
            }
    }
}