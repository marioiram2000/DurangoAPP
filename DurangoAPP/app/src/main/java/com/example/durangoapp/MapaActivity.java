package com.example.durangoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;

import com.mapbox.geojson.Feature;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.util.List;

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

        mapboxMap.addOnMapClickListener(new MapboxMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng point) {
                PointF finalPoint = mapboxMap.getProjection().toScreenLocation(point);
                List<Feature> features = mapboxMap.queryRenderedFeatures(finalPoint);
                for(Feature feature: features){
                    String title = null;
                    if(feature.getProperty("title")!=null){
                        title=feature.getProperty("title").toString();
                    }

                    if(title!=null){
                        Intent intent = null;
                        if(title.contains("1")){
                                intent = new Intent(MapaActivity.this, Zona1_1.class);
                        }else if(title.contains("2")){
                                 intent = new Intent(MapaActivity.this, Zona2_1.class);
                        }else if(title.contains("3")) {
                            intent = new Intent(MapaActivity.this, Zona3_1.class);
                        }else if(title.contains("4")) {
                            intent = new Intent(MapaActivity.this, Zona4_1.class);
                        }else if(title.contains("5")) {
                            intent = new Intent(MapaActivity.this, Zona5_1.class);
                        }else if(title.contains("6")) {
                            intent = new Intent(MapaActivity.this, Zona6_1.class);
                        }else if(title.contains("7")){
                                intent = new Intent(MapaActivity.this, Zona7_1.class);
                        }
                        if(intent!=null)startActivity(intent);
                    }
                };
            }
        });
    }

    /*
    private void addMarker(double lat, double lon, Icon icono) {
        mapboxMap.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lon))
                .title("ubicacion")
                .setIcon(icono));
    }
     */
}