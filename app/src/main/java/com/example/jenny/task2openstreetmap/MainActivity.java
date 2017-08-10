package com.example.jenny.task2openstreetmap;

import android.support.v7.app.AppCompatActivity;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.overlay.Marker;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MapView myMap;
    private MapController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myMap = (MapView) findViewById(R.id.mapView);
        myMap.setTileSource(TileSourceFactory.MAPNIK);
        myMap.setBuiltInZoomControls(true);
        myMap.setMultiTouchControls(true);

        mc = (MapController) myMap.getController();
        mc.setZoom(12);

        GeoPoint center = new GeoPoint(41.2807,1.9646);
        mc.animateTo(center);
        addMarker(center);

        //button
        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

    }

    public void addMarker(GeoPoint center){
        Marker marker = new Marker(myMap);
        marker.setPosition(center);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);

        myMap.getOverlays().clear();
        myMap.getOverlays().add(marker);
        myMap.invalidate();;
    }
}

