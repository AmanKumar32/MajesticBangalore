package com.felight.majesticbangalore;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	// Google Map
	private GoogleMap googleMap;
	// latitude and longitude
	private static final LatLng VIDANASOUDHA = new LatLng(12.979693, 77.590658);
	private static final LatLng LALBAGH = new LatLng(12.952103, 77.585894);
	private static final LatLng CUBBONPARK = new LatLng(12.975536, 77.591000);
	private static final LatLng BANGALOREPALACE = new LatLng(12.998678,
			77.592221);
	private static final LatLng TIPUSULTANPALACE = new LatLng(12.959307,
			77.573687);
	private static final LatLng ULSOORLAKE = new LatLng(12.984065, 77.622295);
	private static final LatLng PLANETARIUM = new LatLng(12.984961, 77.589522);
	private static final LatLng NATIONALPARK = new LatLng(12.770120, 77.567770);
	private static final LatLng WONDERLA = new LatLng(31.360459, -92.408370);
	private static final LatLng NANDIHILLS = new LatLng(13.370154, 77.683455);

	// Markers
	MarkerOptions vidanaSoudha;
	MarkerOptions lalbagh;
	MarkerOptions cubbonPark;
	MarkerOptions bangalorePalace;
	MarkerOptions tipuSultanPalace;
	MarkerOptions ulsoorLake;
	MarkerOptions planetarium;
	MarkerOptions nationalPark;
	MarkerOptions wonderLa;
	MarkerOptions nandiHills;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			// Loading map
			initilizeMap();
			googleMap.setMyLocationEnabled(true);
			// Initialize Markers
			initilizeMarkers();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * function to load map. If map is not created it will create it for you
	 * */
	private void initilizeMap() {
		if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.map)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	private void initilizeMarkers() {

		vidanaSoudha = new MarkerOptions().position(VIDANASOUDHA).title(
				"Vidana Soudha");
		vidanaSoudha.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
		googleMap.addMarker(vidanaSoudha);

	}

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}
}
