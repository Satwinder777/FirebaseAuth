package com.example.firebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.firebase.Adapters.FirstAdapter
import com.example.firebase.Adapters.ThirdAdapter
import com.example.firebase.Adapters.secondAdapter
import com.example.firebase.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var listView: ListView
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var recyclerView2: RecyclerView
//    private lateinit var recyclerView3: RecyclerView
    private lateinit var songArrayList: ArrayList<songData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//                recyclerView = binding.recyclerView1
//        recyclerView2 = binding.recyclerView21
//        recyclerView3 = binding.recyclerView31
//        recyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
//        recyclerView2.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
//        recyclerView3.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
//
//        binding.recyclerView1.layoutManager=  LinearLayoutManager(requireContext())
//        binding.recyclerView21.layoutManager=  LinearLayoutManager(requireContext())
//        binding.recyclerView31.layoutManager=  LinearLayoutManager(requireContext())
//        showVegData()
//        var adapter = FirstAdapter(songArrayList,this.requireContext())
//        var adapter2 = secondAdapter(songArrayList)
//        var adapter3 = ThirdAdapter(songArrayList)
//        recyclerView.adapter= adapter
//        recyclerView2.adapter= adapter2
//        recyclerView3.adapter= adapter3

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showVegData()
        var context =requireContext()
        val recyclerView = binding.recyclerView1
        var recyclerView11 = binding.recyclerView21
        val recyclerView22 = binding.recyclerView31
        var adapter = FirstAdapter(songArrayList,requireContext())
        recyclerView.setHasFixedSize(true)

        recyclerView.adapter = adapter


        //// second Adapter
//        showVegData()

        val recyclerView1 = binding.recyclerView21
        var adapter1 = secondAdapter(songArrayList,context)
        recyclerView1.setHasFixedSize(true)

        recyclerView11.adapter = adapter1


        ////third Adapter
//        showVegData()

        val recyclerView2 = binding.recyclerView31
        var adapter2 = ThirdAdapter(songArrayList,context)
        recyclerView2.setHasFixedSize(true)

        recyclerView22.adapter = adapter2


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