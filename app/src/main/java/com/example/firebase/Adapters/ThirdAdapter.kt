package com.example.firebase.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R
import com.example.firebase.VegData
import com.example.firebase.songData
import com.pbs.testnavgraph.VegAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

 class ThirdAdapter (private val songArrayList: ArrayList<songData>) :
    RecyclerView.Adapter<ThirdAdapter.InnerClass1>() {


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

        }




    }




    class InnerClass1(view: View) : RecyclerView.ViewHolder(view) {

        var artistNAme = view.findViewById<TextView>(R.id.ArtistName)
        var songName = view.findViewById<TextView>(R.id.songName)
        var songCoverImg = view.findViewById<ImageView>(R.id.songCoverImg)



    }
}


