package com.example.firebase.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.Activity.AlbumDetailActivity
import com.example.firebase.R
import com.example.firebase.songData

class secondAdapter(private val songArrayList: ArrayList<songData>, var context: Context) :
    RecyclerView.Adapter<secondAdapter.InnerClass1>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            InnerClass1 {
        val itemView1 =
            LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item, parent, false)
        return InnerClass1(itemView1)


    }

    override fun getItemCount(): Int {
        return songArrayList.size
    }

    override fun onBindViewHolder(holder: InnerClass1, position: Int) {
        val currentItem = songArrayList[position]
        var item:Int = 0




        holder.songName.text = currentItem.songName.toString()
        holder.artistNAme.text = currentItem.artistName.toString()
        holder.songCoverImg.setImageResource(currentItem.img)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, AlbumDetailActivity::class.java)
            context.startActivity(intent)
        }
    }




    class InnerClass1(view: View) : RecyclerView.ViewHolder(view) {

        var artistNAme = view.findViewById<TextView>(R.id.ArtistName)
        var songName = view.findViewById<TextView>(R.id.songName)
        var songCoverImg = view.findViewById<ImageView>(R.id.songCoverImg)



    }
}


