package com.test.kreditplus.apps.adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.test.kreditplus.apps.R
import com.test.kreditplus.apps.image.Image
import kotlinx.android.synthetic.main.adapter_image.view.*
import kotlinx.android.synthetic.main.image_larger.view.*


class ImageAdapter(var context: Context?, var list:ArrayList<Image>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_image, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val img = list.get(position)
        holder.bind(img)
        holder.itemView.setOnClickListener(View.OnClickListener {
            showInLarger(img)
        })
    }

    fun showInLarger(image: Image){
//        val dialog = context?.let { Dialog(it, R.style.Theme_Design_Light) }
//        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        var  v = LayoutInflater.from(context).inflate(R.layout.image_larger)

        val dialog = context?.let { Dialog(it, R.style.Theme_Design_Light) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val factory = LayoutInflater.from(context)
        val view: View = factory.inflate(R.layout.image_larger, null)
        context?.let { Glide.with(it).load(image.path).into(view.dialog_imageview) }
        dialog?.setContentView(view)
        dialog?.show()
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
            fun bind(image:Image){
                context?.let {
                    Glide.with(it).load(image.path).into(itemView.image_news).apply {
                        RequestOptions.overrideOf(600,200)
                    }
                }
            }
    }


}