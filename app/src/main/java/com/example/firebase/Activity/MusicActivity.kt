package com.example.firebase.Activity

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import com.example.firebase.Adapters.AlbumDetailAdapter
import com.example.firebase.R
import com.example.firebase.databinding.ActivityAlbumDetailBinding
import com.example.firebase.databinding.ActivityMusicBinding

class MusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mediaPlayer=MediaPlayer.create(this,R.raw.levels)
        var seekBar = binding.MainSeekBar

        seekBar.setMax(mediaPlayer.getDuration());
        mediaPlayer.setOnCompletionListener {

            mediaPlayer.start()
        }
        var i = AlbumDetailActivity()
//        mediaPlayer = i.mMediaPlayer!!
        binding.MainMusicHeart.setOnClickListener {
            var a:Boolean =false
            if ( a==false){
                binding.MainMusicHeart.setImageResource(R.drawable.baseline_favorite_24)
                Toast.makeText(this, " Added ", Toast.LENGTH_SHORT).show()
                a=true
                Log.e("click", "aaaaa", )

            }
            else{
                binding.MainMusicHeart.setImageResource(R.drawable.fav_24)
                a=false
                Log.e("click", "bbbbbb", )


            }
        }
        var arrList = ArrayList<String>()
        var ins = AlbumDetailAdapter(arrayListOf(), this)

        binding.PlayButton.setOnClickListener {
            var img: ImageView? = AlbumDetailAdapter.getSong.k
            if (mediaPlayer.isPlaying.not()) {
                mediaPlayer.start()

            } else {
                mediaPlayer.pause()


            }
/////
            var a:Boolean= false
            if (a==false){
                binding.PlayButton.setImageResource(R.drawable.pause0)
                Toast.makeText(this, " Added ", Toast.LENGTH_SHORT).show()
                a=true
                Log.e("click", "aaaaa", )

            }
            else{
                binding.PlayButton.setImageResource(R.drawable.play0)
                a=false
                Log.e("click", "bbbbbb", )


            }
            ////

        }

        binding.NextButton.setOnClickListener {}


        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                binding.MainSeekBar.progress = mediaPlayer.currentPosition


                // update the seek bar position to the current position in the song
                handler.postDelayed(
                    this,
                    1000
                ) // schedule the handler to run again after 1 second
            }
        }, 0)
        var initialText = binding.InitialTime.text.toString()



        binding.PreviousButton.setOnClickListener { }
        binding.MainSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {

            var seekfrom = 0
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                // Do something when the SeekBar's progress changes
                if (fromUser) {
                    mediaPlayer.seekTo(progress)

                    // seek to the new position in the song
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@MusicActivity, "onStopTrackingTouch", Toast.LENGTH_SHORT)
                    .show()
                mediaPlayer.seekTo(seekBar?.progress ?: 0)
                mediaPlayer.start()
            }
        })
    }
}