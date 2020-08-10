package com.test.kreditplus.apps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.kreditplus.apps.adapter.ImageAdapter
import com.test.kreditplus.apps.image.Image
import com.test.kreditplus.apps.image.ImageViewModel
import com.test.kreditplus.apps.image.Injector
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    lateinit var adapter:ImageAdapter
    var listimage = ArrayList<Image>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ImageAdapter(context, listimage)
        list.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        list.adapter = adapter

        initUI()


    }

    private fun initUI(){
        listimage.add(Image(R.drawable.pic1))
        listimage.add(Image(R.drawable.pic2))
        listimage.add(Image(R.drawable.pic3))
        listimage.add(Image(R.drawable.pic4))
        listimage.add(Image(R.drawable.pic5))
        listimage.add(Image(R.drawable.pic6))
        listimage.add(Image(R.drawable.pic7))
        listimage.add(Image(R.drawable.pic8))
        listimage.add(Image(R.drawable.pic9))
        listimage.add(Image(R.drawable.pic10))

        val factory = Injector.provideViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(ImageViewModel::class.java)

        viewModel.setImages(listimage)


    }
}
