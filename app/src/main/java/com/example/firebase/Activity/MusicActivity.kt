package com.example.firebase.Activity

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.firebase.Adapters.AlbumDetailAdapter
import com.example.firebase.Google_Facebook_login
import com.example.firebase.R
import com.example.firebase.databinding.ActivityMusicBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.time.Duration
import java.util.concurrent.TimeUnit

class MusicActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMusicBinding

      var songs = listOf<Int>(R.raw.fuck_em_all,
          R.raw.levels,
          R.raw.two,
          R.raw.fuck_em_all,
          R.raw.levels,
          R.raw.two,
          R.raw.fuck_em_all,
          R.raw.levels,
          R.raw.two,
          R.raw.fuck_em_all,
          R.raw.levels,
          R.raw.two,)
    val totalSongs = songs.size

    var mediaPlayer =MediaPlayer()
    var currentSongIndex:Int = 0
    var newval = currentSongIndex

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_music)
        songs = listOf(
            R.raw.fuck_em_all,
            R.raw.levels,
            R.raw.two,
            R.raw.fuck_em_all,
            R.raw.levels,
            R.raw.two,
            R.raw.fuck_em_all,
            R.raw.levels,
            R.raw.two,
            R.raw.fuck_em_all,
            R.raw.levels,
            R.raw.two,
        )

        mediaPlayer = MediaPlayer.create(this, songs[newval])


//        val bottomSheetDialogFragment = BottomSheetDialogFragment()
//        var intent = Intent(this, Google_Facebook_login::class.java)


        var seekBar = binding.MainSeekBar

        seekBar.setMax(mediaPlayer.getDuration());
//        mediaPlayer.setOnCompletionListener {
//
//            mediaPlayer.start()
//        }
        var i = AlbumDetailActivity()
//        mediaPlayer = i.mMediaPlayer!!
        var a: Boolean = false

        binding.MainMusicHeart.setOnClickListener {
            if (a == false) {
                binding.MainMusicHeart.setImageResource(R.drawable.fav_24)
                Toast.makeText(this, " Added ", Toast.LENGTH_SHORT).show()
                a = true
//                Log.e("click", "aaaaa", )
//                bottomSheetDialogFragment.startActivity(intent)

            } else {
                binding.MainMusicHeart.setImageResource(R.drawable.baseline_favorite_24)
                a = false
//                Log.e("click", "bbbbbb",)


            }
        }
            binding.FinalTime.setOnClickListener {
                var btnShowBottomSheet = findViewById<TextView>(R.id.FinalTime)

                // adding on click listener for our button.
                btnShowBottomSheet.setOnClickListener {

                    // on below line we are creating a new bottom sheet dialog.
                    val dialog = BottomSheetDialog(this@MusicActivity)

                    // on below line we are inflating a layout file which we have created.
                    val view = layoutInflater.inflate(R.layout.activity_google_login, null)

                    // on below line we are creating a variable for our button
                    // which we are using to dismiss our dialog.
                    val btnClose = view.findViewById<ImageView>(R.id.imageView)

                    // on below line we are adding on click listener
                    // for our dismissing the dialog button.
                    btnClose.setOnClickListener {
                        // on below line we are calling a dismiss
                        // method to close our dialog.
                        dialog.dismiss()
                    }
                    // below line is use to set cancelable to avoid
                    // closing of dialog box when clicking on the screen.
                    dialog.setCancelable(false)

                    // on below line we are setting
                    // content view to our view.
                    dialog.setContentView(view)

                    // on below line we are calling
                    // a show method to display a dialog.
                    dialog.show()
                }
            }


            var btn: Boolean = false
            binding.PlayButton.setOnClickListener {
                var img: ImageView? = AlbumDetailAdapter.getSong.k
                if (mediaPlayer.isPlaying.not() && btn == false) {
                    playCurrentSong()
                    binding.PlayButton.setImageResource(R.drawable.pause0)

                    btn = true
                } else {
                    binding.PlayButton.setImageResource(R.drawable.play0)
                    mediaPlayer.pause()
                    btn = false
                }
/////

                ////

            }


            binding.NextButton.setOnClickListener {
                newval += 1
                if (currentSongIndex >= totalSongs) {
                    currentSongIndex = 0
                }
                playCurrentSong()
                println(currentSongIndex)
                binding.PlayButton.setImageResource(R.drawable.pause0)
            }


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



            binding.PreviousButton.setOnClickListener {
                newval--
                if (currentSongIndex < 0) {
                    currentSongIndex = totalSongs - 1
                }
                playCurrentSong()
                binding.PlayButton.setImageResource(R.drawable.pause0)
                println(currentSongIndex)
            }
            binding.MainSeekBar.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {

                var seekfrom = 0

                @RequiresApi(Build.VERSION_CODES.O)
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
                    val songDurationTextView = binding.InitialTime
                    val finalduration = binding.FinalTime
                    val duration = Duration.ofMillis(progress.toLong())
                    val minutes = duration.toMinutes()
                    val seconds = duration.minusMinutes(minutes).seconds
                    val formattedDuration = String.format("%d:%02d", minutes, seconds)
                    songDurationTextView.text = formattedDuration


                    val totalDuration = mediaPlayer.duration

                    val minutes1 = TimeUnit.MILLISECONDS.toMinutes(totalDuration.toLong())
                    val seconds1 = TimeUnit.MILLISECONDS.toSeconds(totalDuration.toLong()) -
                            TimeUnit.MINUTES.toSeconds(minutes1)

                    val formattedTime = String.format("%02d:%02d", minutes1, seconds1)

                    val textView = binding.FinalTime
                    textView.text = formattedTime
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    binding.PlayButton.setImageResource(R.drawable.pause0)
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    Toast.makeText(this@MusicActivity, "onStopTrackingTouch", Toast.LENGTH_SHORT)
                        .show()
                    mediaPlayer.seekTo(seekBar?.progress ?: mediaPlayer.duration)
                    mediaPlayer.start()
                }
            })


            mediaPlayer.setOnCompletionListener {
                newval += 1
                playCurrentSong()
                println(newval)
                binding.PlayButton.setImageResource(R.drawable.pause0)

            }
4
        }




  fun playCurrentSong(){
      mediaPlayer.stop()
      mediaPlayer.release()
      mediaPlayer = MediaPlayer.create(this, songs[newval])

      mediaPlayer.start()
//      mediaPlayer.start()
  }
    fun nextSong(){
        newval+=1
        playCurrentSong()
        println(newval)
        binding.PlayButton.setImageResource(R.drawable.pause0)}
    }



