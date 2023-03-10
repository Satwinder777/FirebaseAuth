package com.example.firebase

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.R
import com.pbs.testnavgraph.VegAdapter


class FavFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VegAdapter
    private lateinit var vegArrayList: ArrayList<VegData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showVegData()

        val LayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = LayoutManager
        recyclerView.setHasFixedSize(true)
        adapter = VegAdapter(vegArrayList)
        recyclerView.adapter = adapter


    }

    private fun showVegData() {
        vegArrayList = ArrayList()
        val vegimg = arrayOf(
            R.drawable.simlamirch,
            R.drawable.patato,
            R.drawable.barcolli,
            R.drawable.onions,
            R.drawable.carrot,
            R.drawable.simlamirch,
            R.drawable.patato,
            R.drawable.barcolli,
            R.drawable.onions,
            R.drawable.carrot,
            R.drawable.simlamirch,
            R.drawable.patato,
            R.drawable.barcolli,
            R.drawable.onions,
            R.drawable.carrot,


            )

        val vegname = arrayOf(
            "Simlamirch",
            "Patato",
            "Barcolli",
            "Onions",
            "Carrot",
            "Simlamirch",
            "Patato",
            "Barcolli",
            "Onions",
            "Carrot",
            "Simlamirch",
            "Patato",
            "Barcolli",
            "Onions",
            "Carrot",

            )

        val vegweight = arrayOf(
            "1Kg",
            "2Kg",
            "3Kg",
            "2Kg",
            "1Kg",
            "5Kg",
            "1Kg",
            "2Kg",
            "3Kg",
            "2Kg",
            "1Kg",
            "5Kg",
            "1Kg",
            "2Kg",
            "3Kg",
            "2Kg",
            "1Kg",
            "5Kg",

            )


        val vegcost:  MutableList<Int> = ArrayList()
        for (i in 1..15){
            var a=  (1..20).random()
            a = a.toInt()
            vegcost.add(a.toInt())

        }
//        Log.e("random", "log---"+vegCost)

        for (i in vegimg.indices) {
            val vegData = VegData(vegname[i], vegweight[i], vegcost[i], vegimg[i])
            vegArrayList.add(vegData)
        }
    }
}


