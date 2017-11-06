package com.example.vubuntu.mymapone;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     *
     * Tirupati->13.6288° N, 79.4192° E
     * colony temple-> lat: 17.8283, lon: 80.8352
     *
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //sec video--hybrid map type
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        // Add a marker in Sydney and move the camera
        LatLng tirupati = new LatLng(13.6288, 79.4192);
        //mMap.addMarker(new MarkerOptions().position(tirupati).title("Tirupati"));
        //instead of above, below on can be used
        mMap.addMarker(new MarkerOptions().position(tirupati).title("Tirupati").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(tirupati));
        //instead of above, below on can be used
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tirupati,19));
    }
}
