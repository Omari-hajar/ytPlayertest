package com.example.ytplayer_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ytplayer_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnVideoClickListener {

    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<VideoData>()
    lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvMain = binding.rvMain

        binding.rvMain.adapter = RVAdapter(list, this)
        binding.rvMain.layoutManager = LinearLayoutManager(this)

        binding.rvMain.adapter!!.notifyDataSetChanged()

        list.add(VideoData("Last of US", "4VxWEK5orZ0", R.drawable.pexels_aleksey_kuprikov_3493777 ))
        list.add(VideoData("Mysterious Student", "dd8y4JAtudk", R.drawable.pexels_arthouse_studio_4534200))
        list.add(VideoData("Dark Academia", "h0ZiJbux4QI", R.drawable.pexels_eberhard_grossgasteiger_443446 ))
        list.add(VideoData("Pride and Prejudice", "jEpysl6wCPE", R.drawable.pexels_jj_perks_8567870))
        list.add(VideoData("Last of US", "4VxWEK5orZ0", R.drawable.pexels_tom__mal_k_3509971))
        list.add(VideoData("Last of US", "4VxWEK5orZ0", R.drawable.pexels_luis_del_r_o_15286))
        list.add(VideoData("Last of US", "4VxWEK5orZ0", R.drawable.pexels_aleksey_kuprikov_3493777 ))
        list.add(VideoData("Last of US", "4VxWEK5orZ0", R.drawable.pexels_tom__mal_k_3509971))
        list.add(VideoData("Last of US", "4VxWEK5orZ0", R.drawable.pexels_kirill_lazarev_9801136))



    }





    override fun onVideoItemClicked(position: Int) {
        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra("video", list[position].video)
        startActivity(intent)
    }
}