package com.pbs.testnavgraph

//class FruitAdapter {
//}
//package com.pbs.testnavgraph

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R
import com.example.firebase.VegData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class VegAdapter(private val fruitArrayList: ArrayList<VegData>) :
    RecyclerView.Adapter<VegAdapter.InnerClass1>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            InnerClass1 {
        val itemView1 =
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_view_item, parent, false)
        return InnerClass1(itemView1)


    }

    override fun getItemCount(): Int {
        return fruitArrayList.size
    }

    override fun onBindViewHolder(holder: InnerClass1, position: Int) {
        val currentItem = fruitArrayList[position]
        var item:Int = 0
        holder.vegName.text = currentItem.vegetableName.toString()
        holder.vegWeight.text = currentItem.weight.toString()
        holder.vegImg.setImageResource(currentItem.vegImgage)
        holder.perVegPrize.text = currentItem.totalcost.toString()
        holder.totalItem.text = item.toString()
        holder.incBtn.setOnClickListener {
            GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    // TODO("Update UI")

                    if (item>=0) {
                        item += 1
                        holder.totalItem.text = item.toString()

                        var a = currentItem.totalcost.toInt()
                        var c = a*item
                        holder.perVegPrize.text = c.toString()
                    }
                    else {
                        Toast.makeText(holder.endBtn.context,"new", Toast.LENGTH_SHORT).show()
                    }
                }
                //TODO("do background task...")
            }


        }
       holder.decBtn.setOnClickListener {
            GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    // TODO("Update UI")

                    if (item>0) {
                        item -= 1
                        holder.totalItem.text = item.toString()
                        var a = currentItem.totalcost.toInt()
                        var c = a*item
                        holder.perVegPrize.text = c.toString()
                    }
                    else {
                        Toast.makeText(holder.endBtn.context,"less", Toast.LENGTH_SHORT).show()
                    }
                }
                //TODO("do background task...")
            }
        }
//        var c = a.toString().toInt() + b.toString().toInt()
        holder.endBtn.setOnClickListener {

                val position = holder.adapterPosition
                val model = fruitArrayList[position]
            Log.e("adapterpostion", "adapterposion is "+ position )
            fruitArrayList.removeAt(position)
               notifyDataSetChanged()
            Toast.makeText(holder.vegName.context, "you deleted : ${holder.vegName.text.toString()}", Toast.LENGTH_SHORT).show()

        }



    }




    class InnerClass1(view: View) : RecyclerView.ViewHolder(view) {
        val vegName = view.findViewById<TextView>(R.id.textView5)
        val vegWeight = view.findViewById<TextView>(R.id.textView6)
        val incBtn = view.findViewById<Button>(R.id.button)
        val decBtn = view.findViewById<Button>(R.id.button2)
        val totalItem = view.findViewById<TextView>(R.id.textView8)
        val endBtn = view.findViewById<ImageView>(R.id.imageView7)
        val perVegPrize = view.findViewById<TextView>(R.id.textView7)
        val vegImg = view.findViewById<ImageView>(R.id.imageView6)

    }
}


