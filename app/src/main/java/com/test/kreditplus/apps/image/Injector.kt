package com.test.kreditplus.apps.image

import android.widget.ImageView

object Injector{
    fun provideViewModelFactory() : ImageFactory{
        return ImageFactory(ImageRepo.getInstance(ImageStorage.getInstance().imageDao))
    }
}