package com.example.jenny.task2openstreetmap

import android.support.v7.app.AppCompatActivity
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapController
import org.osmdroid.views.MapView
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.overlay.Marker
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var myMap: MapView? = null
    private var mc: MapController? = null

    @Override
    protected fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myMap = findViewById(R.id.mapView) as MapView
        myMap!!.setTileSource(TileSourceFactory.MAPNIK)
        myMap!!.setBuiltInZoomControls(true)
        myMap!!.setMultiTouchControls(true)

        mc = myMap!!.getController() as MapController
        mc!!.setZoom(12)

        val center = GeoPoint(41.2807, 1.9646)
        mc!!.animateTo(center)
        addMarker(center)

        //button
        val btnExit = findViewById(R.id.btnExit) as Button
        btnExit.setOnClickListener(object : View.OnClickListener() {

            @Override
            fun onClick(view: View) {
                finish()
                System.exit(0)
            }
        })

    }

    fun addMarker(center: GeoPoint) {
        val marker = Marker(myMap)
        marker.setPosition(center)
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)

        myMap!!.getOverlays().clear()
        myMap!!.getOverlays().add(marker)
        myMap!!.invalidate()
    }
}

