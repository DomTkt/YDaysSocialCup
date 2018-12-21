package com.example.dom.ydayssocialcup.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.camera.CameraPosition

class MapFragment : Fragment() {

    private lateinit var mapView: MapView
    private var ZOOM_MAP : Double = 16.0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        Mapbox.getInstance(requireContext(), "pk.eyJ1IjoiZG9tdGt0IiwiYSI6ImNqcDl2ZGpldDBianUzdm04MWVjNmQyejMifQ.XgzItEeH0XzYWwnkp4SYtQ")
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        var positionLyon = LatLng(45.75, 4.85)
        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(OnMapReadyCallback { mapboxMap ->
            mapboxMap.addMarker(
                MarkerOptions()
                    .position(positionLyon)
            )

            mapboxMap.cameraPosition = CameraPosition.Builder()
                .target(positionLyon)
                .zoom(ZOOM_MAP)
                .build()
        })
        return view
    }

    override fun onDetach() {
        super.onDetach()
        mapView.onDestroy()
    }

    companion object {
        fun newInstance(): MapFragment = MapFragment()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)

    }
}