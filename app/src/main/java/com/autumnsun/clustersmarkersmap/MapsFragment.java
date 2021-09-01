package com.autumnsun.clustersmarkersmap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;


public class MapsFragment extends Fragment {
    private GoogleMap mMap;
    private ClusterManager<MyClusterItem> clusterManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        //initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                mMap = googleMap;
                setUpClusterer();
            }
        });
        return view;
    }

    private void setUpClusterer() {
        // Harita ilk olarak Istanbulda acilir.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(41.00787278465367, 28.983237405528907), 10));
        // ClusterManager nesnemizi uretiyoruz.Burda activity context ihtiyaci vardir.
        // Eger Actvity kullaniyorsak direk this diyebilirsiniz.
        clusterManager = new ClusterManager<MyClusterItem>(getActivity(), mMap);
        // Mapimize artik olusturdugumu clusterManager setliyoruz ve kamerada degisiklikleri izlemesini
        // saglatiyoruz bu sayede olusturdumu
        mMap.setOnCameraIdleListener(clusterManager);
        mMap.setOnMarkerClickListener(clusterManager);
        // MarkerList
        setMarkerList();
    }

    private void setMarkerList() {
        clusterManager.addItem(new MyClusterItem(41.08246437824261, 28.85896640782512, "Marker -> 1", "Description -> 1"));
        clusterManager.addItem(new MyClusterItem(41.04101946294376, 29.00129489690629, "Marker -> 2", "Description -> 2"));
        clusterManager.addItem(new MyClusterItem(41.02664922062891, 28.9741820419167, "Marker -> 3", "Description -> 3"));
        clusterManager.addItem(new MyClusterItem(41.094085496470726, 28.83562915026621, "Marker -> 4", "Description -> 4"));
        clusterManager.addItem(new MyClusterItem(41.04862758536943, 29.024215055945554, "Marker -> 5", "Description -> 5"));
        clusterManager.addItem(new MyClusterItem(41.04527163251746, 28.99785637928587, "Marker -> 6", "Description -> 6"));
        clusterManager.addItem(new MyClusterItem(41.08027610477752, 28.84809918573745, "Marker -> 7", "Description -> 7"));
        clusterManager.addItem(new MyClusterItem(41.07291228652013, 28.82519691013705, "Marker -> 8", "Description -> 8"));
        clusterManager.addItem(new MyClusterItem(41.06681727904338, 28.816779359741403, "Marker -> 9", "Description -> 9"));
        clusterManager.addItem(new MyClusterItem(41.06174119252741, 28.85399003259965, "Marker -> 10", "Description -> 10"));
    }
}