package com.example.durangoapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));
        MapView mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync((OnMapReadyCallback) this);
        mapView.setStyleUrl("mapbox://styles/sigecorp/ckxeihwgsfufp15nskehnx08r");

    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        mapboxMap.setCameraPosition(new CameraPosition.Builder()
            .target(new LatLng(43.168698, -2.6329660))
            .zoom(13)
            .build());
    }
}