package com.example.firebase

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebase.Adapters.FirstAdapter
import com.example.firebase.Adapters.ThirdAdapter
import com.example.firebase.Adapters.secondAdapter
import com.example.firebase.databinding.ActivityMainBinding
import com.example.firebase.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity1 : AppCompatActivity() {
    private lateinit var navController: NavController
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var recyclerView2: RecyclerView
//    private lateinit var recyclerView3: RecyclerView
    private lateinit var binding: FragmentHomeBinding
    private lateinit var songArrayList: ArrayList<songData>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        binding = FragmentHomeBinding.inflate(layoutInflater)



        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
       navController = navHostFragment.navController
       val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bNView)

        setupWithNavController(bottomNavigationView , navController)

//        recyclerView = findViewById(R.id.recycler_view1)
//        recyclerView2 = findViewById(R.id.recyclerView21)
//        recyclerView3 = findViewById(R.id.recyclerView31)
//
//        binding.recyclerView1.layoutManager=  LinearLayoutManager(this)
//        binding.recyclerView21.layoutManager=  LinearLayoutManager(this)
//        binding.recyclerView31.layoutManager=  LinearLayoutManager(this)
//        showVegData()
//        var adapter = FirstAdapter(songArrayList,this)
//        var adapter2 =secondAdapter(songArrayList)
//        var adapter3 =ThirdAdapter(songArrayList)
//        recyclerView.adapter= adapter
//        recyclerView2.adapter= adapter2
//        recyclerView3.adapter= adapter3
    }








    private fun showVegData() {
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


//        val vegcost:  MutableList<Int> = ArrayList()
//        for (i in 1..15){
//            var a=  (1..20).random()
//            a = a.toInt()
//            vegcost.add(a.toInt())

//        }

        for (i in songimg.indices) {
            val songData = songData(songname[i],artistName[i],songimg[i])
            songArrayList.add(songData)
        }

    }
    }