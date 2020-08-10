package com.test.kreditplus.apps.image

class ImageRepo private constructor(private val imageDao: ImageDao){
    fun getImages() = imageDao.getImage()
    fun setImage(listImg:ArrayList<Image>) = imageDao.setImage(listImg)

    companion object{

        @Volatile private var instance: ImageRepo? = null

        fun getInstance(sourceDao: ImageDao) =
            instance ?: synchronized(this){
                instance ?: ImageRepo(sourceDao).also { instance = it }
            }
    }
}