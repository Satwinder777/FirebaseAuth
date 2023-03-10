package com.example.firebase.Activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.Adapters.AlbumDetailAdapter
import com.example.firebase.R
import com.example.firebase.databinding.ActivityAlbumDetailBinding
import com.example.firebase.songData

class AlbumDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumDetailBinding
    private lateinit var recyclerView: RecyclerView
    private  var songArrayList: ArrayList<songData> ?= arrayListOf()
      var song= arrayOf<Int>()
    var mMediaPlayer: MediaPlayer? = null
     var btn :ImageView?=null
    var progressStatus:Int=0
    private lateinit var handler: Handler
//    lateinit var adapter1: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.albumRecycler)
        btn =findViewById(R.id.newIdplayBtn)



        binding.albumRecycler.layoutManager = LinearLayoutManager(this)

        data()

        Log.e("songArrayList", "onCreate: "+songArrayList?.size )

        var adapter = AlbumDetailAdapter(songArrayList!!,this)

        binding.albumRecycler.adapter = adapter

        var a=false
        binding.newIdlove.setOnClickListener {

            if (a==false){
                binding.newIdlove.setImageResource(R.drawable.baseline_favorite_24)
                Toast.makeText(this, " Added ", Toast.LENGTH_SHORT).show()
                a=true
                Log.e("click", "aaaaa", )

            }
            else{
                binding.newIdlove.setImageResource(R.drawable.fav_24)
                a=false
                Log.e("click", "bbbbbb", )


            }

        }
        binding.playAllId.setOnClickListener { adapter.playAll() }
        binding.musicItem.setOnClickListener {
            val intent = Intent(this,MusicActivity::class.java)
            startActivity(intent)
        }
//        mMediaPlayer = MediaPlayer.create(this,R.raw.levels)



        //play and pause song

        binding.newIdplayBtn.setOnClickListener {
            adapter.playnpause()

        }
        var btn:ImageView = binding.newIdplayBtn
        var k = AlbumDetailAdapter.getSong.song(btn)

//        ifmediaisplay(MediaPlayer())

//         handler = Handler(Handler.Callback {
//            if (mMediaPlayer?.isPlaying == true) {
//                progressStatus++
//            }
//            binding.progressBarHorizontal.progress = progressStatus
//            handler.sendEmptyMessageDelayed(0, 100)
//
//            true
//        })
//
//        handler?.sendEmptyMessage(0)

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            @SuppressLint("SuspiciousIndentation")
            override fun run() {

                var end:Int = adapter.duration/1000
                println(end)

                if(progressStatus!=end){
                    progressStatus++

                }
                if (progressStatus == end){

                    handler.removeCallbacks { println("completed") }
                }
                binding.progressBarHorizontal.max=end
                binding.progressBarHorizontal.progress = progressStatus
                            Log.e("progCheck", "onCreate:${progressStatus}" )

                handler?.sendEmptyMessageDelayed(0, 100)

//                binding.progressBarHorizontal.progress = MediaPlayer().duration // update the seek bar position to the current position in the song
                handler.postDelayed(this, 1000)
            // schedule the handler to run again after 1 second

            }
        }, 0)



    }

//    fun start0(){
//        var k = AlbumDetailActivity()
//        k.progressStatus *0
//    }

    private fun data(){
        songArrayList?.clear()
        songArrayList = ArrayList()
        val songimg = arrayOf(
            R.raw.eightteen,
            R.raw.eightth,
            R.raw.eleven,
            R.raw.fifth,
            R.raw.first,
            R.raw. fourteen,
            R.raw.fourth,
            R.raw.nineteen,
            R.raw. nineth,
            R.raw.second,
            R.raw.seven,
            R.raw.seventeen,
            R.raw.sixteen,
            R.raw.sixth,
            R.raw.tenth,
            R.raw.third,
            R.raw.thirteen,
            R.raw.twenty,
            R.raw.eightteen,
            R.raw.eightth,
            R.raw.eleven,
            R.raw.fifth,
            R.raw.first,
            R.raw. fourteen,
            R.raw.fourth,
            R.raw.nineteen,
            R.raw. nineth,
            R.raw.second,
            R.raw.seven,
            R.raw.seventeen,
            R.raw.sixteen,
            R.raw.sixth,
            R.raw.tenth,
            R.raw.third,
            R.raw.thirteen,
            R.raw.twenty,


            )

        val songname = arrayOf(
            "Legend",
            "Kalli dunalli",
            "Kalla Chann",
            "Dhoom machale",
            "kabuutar baji",
            "kaccha badam",
            "Legend",
            "Kalli dunalli",
            "Kalla Chann",
            "Dhoom machale",
            "kabuutar baji",
            "kaccha badam",
            "Legend",
            "Kalli dunalli",
            "Kalla Chann",
            "Dhoom machale",
            "kabuutar baji",
            "kaccha badam", "Kalli dunalli",
            "Kalla Chann",
            "Legend",
            "Kalli dunalli",
            "Kalla Chann",
            "Dhoom machale",
            "kabuutar baji",
            "kaccha badam",
            "Legend",
            "Kalli dunalli",
            "Kalla Chann",
            "Dhoom machale",
            "kabuutar baji",
            "kaccha badam",
            "Legend",
            "Kalli dunalli",
            "Kalla Chann",
            "Dhoom machale",
            "kabuutar baji",
            "kaccha badam",
            "Kalli dunalli",
            "Kalla Chann",


            )

        val artistName = arrayOf(
            "Sidhu Moose Wala",
            "Amrit Mann",
            "Babbu Mann",
            "Gurdas Mann",
            "Sharry Mann",
            "Kubbeer Jhinger",
            "Surjit Chamkila",
            "Kulwinder Billa",
            "jitta jaildar",
            "Parmish Verma ",
            "Gurlej Akter",
            "Janni",
            "B-Prakk",
            "Ammy Virk",
            "Sultan",
            "Garry Sandhu",
            "Karan Aujla",
            "Akhil",
            "Ammy Virk",
            "Sidhu Moose Wala",
            "Amrit Mann",
            "Babbu Mann",
            "Gurdas Mann",
            "Sharry Mann",
            "Kubbeer Jhinger",
            "Surjit Chamkila",
            "Kulwinder Billa",
            "jitta jaildar",
            "Parmish Verma ",
            "Gurlej Akter",
            "Janni",
            "B-Prakk",
            "Ammy Virk",
            "Sultan",
            "Garry Sandhu",
            "Karan Aujla",
            "Akhil",
            "Ammy Virk",


            )
        song = arrayOf(R.raw.fuck_em_all,R.raw.levels,R.raw.two,
            R.raw.fuck_em_all,R.raw.levels,R.raw.two,
            R.raw.fuck_em_all,R.raw.levels,R.raw.two,
            R.raw.fuck_em_all,R.raw.levels,R.raw.two,
            R.raw.fuck_em_all,R.raw.levels,R.raw.two,
            R.raw.fuck_em_all,R.raw.levels,R.raw.two,
            R.raw.fuck_em_all,R.raw.levels,R.raw.two,

            )


//        val vegcost:  MutableList<Int> = ArrayList()
//        for (i in 1..15){
//            var a=  (1..20).random()
//            a = a.toInt()
//            vegcost.add(a.toInt())

//        }

        for (i in songimg.indices) {
            val songData = songData(songname[i],artistName[i],songimg[i])
            songArrayList?.add(songData)
        }




}

//    fun ifmediaisplay(context: Context,mediaPlayer: MediaPlayer){
//        btn =findViewById(R.id.newIdplayBtn)
//
//        if (!mediaPlayer.isPlaying){
//            btn.setImageResource(R.drawable.play0)
//        }
//        else{
//            btn.setImageResource(R.drawable.pause0)
//        }
//    }
//    var b:Boolean=false
//    fun changeImg(){
//        if (b==false){
//               btn?.setImageResource(R.drawable.pause0)
////            mMediaPlayer?.start()
//
//            b=true
//        }
//        else{
//                btn?.setImageResource(R.drawable.play0)
////            mMediaPlayer?.pause()
//
//            b=false
//        }
//        Log.e("click", "onCreate: clicked", )
//    }



}