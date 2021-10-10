package com.example.ytplayer_test

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ytplayer_test.databinding.ActivityVideoBinding

class RVAdapter(private val list: ArrayList<VideoData>, private val onVideoClickListener: OnVideoClickListener): RecyclerView.Adapter<VideoViewHolder>() {

    var isClicked = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val v =  ActivityVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(v)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val item = list[position]

        //holder.binding.tvTitle.text= item.title

        holder.binding.tvTitle.text = item.title
        holder.binding.tvTitle.setTextColor(Color.parseColor("#000000"))

        if (item.image != null){
            Glide.with(holder.binding.root.context)
                .load(item.image)
                .into(holder.binding.ivImage)
        } else{
            holder.binding.ivImage.setImageResource(R.drawable.pexels_kirill_lazarev_9801136)
        }



        holder.binding.root.setOnClickListener {
           // onMovieClickListener.onMovieItemClicked(position)
            onVideoClickListener.onVideoItemClicked(position)
            isClicked = true
            grayOutTask(holder.binding.tvTitle, isClicked)

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun grayOutTask(taskTitle: TextView, isClicked: Boolean){
        if(isClicked){
            taskTitle.setTextColor(Color.parseColor("#e3e3e3"))
        }else{
            taskTitle.setTextColor(Color.parseColor("#000000"))
        }
    }


}