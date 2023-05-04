package com.example.firebase.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.Activity.AlbumDetailActivity
import com.example.firebase.R
import com.example.firebase.VegData
import com.example.firebase.songData
import com.pbs.testnavgraph.VegAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

 class FirstAdapter (private val songArrayList: ArrayList<songData> ,var context: Context) :
    RecyclerView.Adapter<FirstAdapter.InnerClass1>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            InnerClass1 {
        val itemView1 =
                    LayoutInflater.from(parent.context).inflate(R.layout.album_rv_item, parent, false)
        return InnerClass1(itemView1)


    }

    override fun getItemCount(): Int {
        return songArrayList.size
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: InnerClass1, position: Int) {
        val currentItem = songArrayList[position]




        holder.songName.text = currentItem.songName.toString()
        holder.artistNAme.text = currentItem.artistName
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


