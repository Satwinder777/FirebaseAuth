package com.example.firebase

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.Places
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.net.PlacesClient
import java.util.*

class ExplorerFragment : Fragment(),GoogleMap.OnMapLongClickListener{
    private lateinit var placesClient: PlacesClient
    private lateinit var gm :GoogleMap



    private val callback = OnMapReadyCallback { googleMap ->
        gm = googleMap
       gm.mapType = GoogleMap.MAP_TYPE_NORMAL
        gm.uiSettings.isZoomControlsEnabled = true
        val sydney = LatLng(-34.0, 151.0)
        gm.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        gm.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        // Customize the map


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explorer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        initView()

    }
    private fun initView() {


        if (!com.google.android.libraries.places.api.Places.isInitialized()) {
            com.google.android.libraries.places.api.Places.initialize(
                requireActivity(), R.string.google_maps_key.toString(), Locale.US
            )
        }
        placesClient = com.google.android.libraries.places.api.Places.createClient(requireActivity())
    }

    override fun onMapLongClick(p0: LatLng) {

            gm.addMarker(MarkerOptions().position(p0).draggable(true))

    }


}