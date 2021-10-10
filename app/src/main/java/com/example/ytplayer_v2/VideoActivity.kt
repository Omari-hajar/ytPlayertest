package com.example.ytplayer_v2

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.example.ytplayer_test.databinding.VideoLayoutBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult



class VideoActivity : YouTubeBaseActivity(){

    private lateinit var binding: VideoLayoutBinding

   //val video_ID ="85Pq82KwtrE"
    val api_Key ="AIzaSyCX0Q15ivepJSplmDgpnuh6pkanxyUU8BQ"

    private lateinit var youtubePlayer: com.google.android.youtube.player.YouTubePlayerView
    private lateinit var youtubePLayerInit: com.google.android.youtube.player.YouTubePlayer.OnInitializedListener


    private var timeStamp= 0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VideoLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

       youtubePlayer = binding.ytPlayer

        val intentValue = intent.getStringExtra("video")

        val link = intentValue.toString()


        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        youtubePLayerInit = object : com.google.android.youtube.player.YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: com.google.android.youtube.player.YouTubePlayer.Provider?,
                p1: com.google.android.youtube.player.YouTubePlayer?,
                p2: Boolean
            ) {
               p1?.loadVideo(link)
            }

            override fun onInitializationFailure(
                p0: com.google.android.youtube.player.YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext, "Something is wrong $p0 + $p1", Toast.LENGTH_LONG).show()
                Log.d("Main", "$p0 + $p1")
            }
        }

        youtubePlayer.initialize(api_Key, youtubePLayerInit)


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)


        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(applicationContext,"LandScape Mode", Toast.LENGTH_LONG).show()

        } else if(newConfig.orientation === Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(applicationContext,"Portrait Mode", Toast.LENGTH_LONG).show()

        }
        }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putFloat("timeStamp", timeStamp)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        timeStamp = savedInstanceState.getFloat("timeStamp", 0f)
    }

}