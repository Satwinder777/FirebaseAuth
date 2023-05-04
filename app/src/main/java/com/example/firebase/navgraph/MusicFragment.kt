package com.example.firebase

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicFragment : Fragment() {


    var mContext:Context ?= null
    private lateinit var adapter: MusicAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var musicArrayList: ArrayList<MusicData>


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData()

        val LayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LayoutManager
        recyclerView.setHasFixedSize(true)
//        adapter = MusicAdapter(musicArrayList,mContext)
        adapter = MusicAdapter(musicArrayList,mContext)
        recyclerView.adapter = adapter
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MusicFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }


    }


    //code Start From Here

    private fun showData(){
        musicArrayList = arrayListOf()

        val img = arrayOf(
            R.drawable.fea,
            R.drawable.moosetape,
            R.drawable.level,
            R.drawable.fea,
            R.drawable.moosetape,
            R.drawable.level,
            R.drawable.fea,
            R.drawable.moosetape,
            R.drawable.level,
            R.drawable.fea,
            R.drawable.moosetape,
            R.drawable.level,


        )

        val song = arrayOf(
           "Level",
            "Fuck em All",
            "Legend",
            "Devil",
            "So High",
            "Level",
            "Fuck em All",
            "Legend",
            "Devil",
            "So High",
            "Level",
            "Fuck em All",
            "Legend",
            "Devil",
            "So High",
            "Level",
            "Fuck em All",
            "Legend",
            "Devil",
            "So High",



        )

        val artistName = arrayOf(
            "Sidhu Moose",
            "Satwinder",
            "Naresh",
            "Sidhu Moose",
            "Param",
            "Sidhu Moose",
            "Satwinder",
            "Sidhu Moose",
            "Naresh",
            "Sidhu Moose",
            "Sidhu Moose",
            "Naresh",

        )

        for (i in img.indices){
            val musicData = MusicData(song[i], artistName[i],img[i])
            musicArrayList.add(musicData)
        }
    }
}