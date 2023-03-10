package com.example.firebase.Adapters

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R
import com.example.firebase.songData

class AlbumDetailAdapter (private val songArrayList: ArrayList<songData>,var context: Context) :
    RecyclerView.Adapter<AlbumDetailAdapter.InnerClass1>() {
    private lateinit var mediaPlayer: MediaPlayer
    var duration:Int = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            InnerClass1 {
        val itemView1 =
            LayoutInflater.from(parent.context).inflate(R.layout.track_rv_item, parent, false)
        return InnerClass1(itemView1)




    }

    override fun getItemCount(): Int {
        return songArrayList.size
    }

    override fun onBindViewHolder(holder: InnerClass1, position: Int) {
        mediaPlayer = MediaPlayer.create(context,R.raw.levels)
        mediaPlayer.pause()

        val currentItem = songArrayList[position]
        var item:Int = 0

        holder.songName.text = currentItem.songName.toString()
        holder.artistNAme.text = currentItem.artistName.toString()
        holder.songCoverImg.setImageResource(currentItem.img)
        holder.itemView.setOnClickListener {
//            play(position)
//            updateDuration(duration)


            if (!mediaPlayer.isPlaying){
                play(position)
//                holder.btn.setBackgroundResource(R.drawable.pause0)
            }
            else{
                mediaPlayer.pause()
//                holder.btn.setBackgroundResource(R.drawable.play0)
                getSong.k?.setImageResource(R.drawable.play0)
            }

        }




    }




    class InnerClass1(view: View) : RecyclerView.ViewHolder(view) {

        var artistNAme = view.findViewById<TextView>(R.id.ArtistNameAlbusitem)
        var songName = view.findViewById<TextView>(R.id.songNameAlbusitem)
        var songCoverImg = view.findViewById<ImageView>(R.id.songNameAlbusitemAlbusitem)
        var btn = view.findViewById<Button>(R.id.newIdplayBtn)


    }

     interface getSong{
         companion object {
              var k: ImageView? =null

             fun song(a: ImageView){
             k=a
             }

         }
     }

var songs:Any=0
    fun play(position: Int){
        var img: ImageView? = getSong.k

        var song = when(position){
             4,7,10,13,16,19,21-> {

                  mediaPlayer=MediaPlayer.create(context,R.raw.levels)
                 playnpause()

             }
             2,5,8,11,14,17,20,23,26-> {

                 mediaPlayer=MediaPlayer.create(context,R.raw.fuck_em_all)
                 playnpause()

             }
            1, 3,6,9,12,15,18,21,24,27,30-> {

                 mediaPlayer=MediaPlayer.create(context,R.raw.two)
                 playnpause()

             }

             else -> "invalid number"
         }
        songs = song



     }
    fun playnpause() {
        if (!mediaPlayer.isPlaying){
            getSong.k?.setImageResource(R.drawable.pause0)

            mediaPlayer.start()
            duration = mediaPlayer.duration
            println("duration  : $duration/1000")
//            updateDuration(duration)
            var m=mediaPlayer.currentPosition
            println("curren")
        }
        else{
            mediaPlayer.pause()
            getSong.k?.setImageResource(R.drawable.play0)


        }


    }


//
//fun updateDuration(duration1:Int){
//    duration = mediaPlayer.duration
//    println(duration)
//    println(duration1)
//}
    fun playAll(){
        var position:Int=0
        var song = when(position){
            0,4,7,10,13,16,19,21-> {

                mediaPlayer=MediaPlayer.create(context,R.raw.levels)
                playnpause()

            }
            2,5,8,11,14,17,20,23,26-> {

                mediaPlayer=MediaPlayer.create(context,R.raw.fuck_em_all)
                playnpause()

            }
            1, 3,6,9,12,15,18,21,24,27,30-> {

                mediaPlayer=MediaPlayer.create(context,R.raw.two)
                playnpause()

            }

            else -> "invalid number"

        }
        playnextsong(position)



    }
    fun playnextsong(currentSong:Int){
        mediaPlayer.setOnCompletionListener {
            currentSong+1
            mediaPlayer.start()
        }
    }


}


