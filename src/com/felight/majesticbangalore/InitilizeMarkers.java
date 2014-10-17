package com.felight.majesticbangalore;

import java.util.ArrayList;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InitilizeMarkers {
	// Google Map
	private static GoogleMap googleMap;

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
	static MarkerOptions vidanaSoudha;
	static MarkerOptions lalbagh;
	static MarkerOptions cubbonPark;
	static MarkerOptions bangalorePalace;
	static MarkerOptions tipuSultanPalace;
	static MarkerOptions ulsoorLake;
	static MarkerOptions planetarium;
	static MarkerOptions nationalPark;
	static MarkerOptions wonderLa;
	static MarkerOptions nandiHills;

	static void initilizeMarkers() {

		vidanaSoudha = new MarkerOptions().position(VIDANASOUDHA).title(
				"Vidana Soudha");
		vidanaSoudha.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
		googleMap.addMarker(vidanaSoudha);

	}

}
