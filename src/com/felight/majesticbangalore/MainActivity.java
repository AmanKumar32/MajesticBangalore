package com.felight.majesticbangalore;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			// Loading map
			initilizeMap();
			// Initialize Markers
			initilizeMarkers();
			// Get Current Location
			getLocation();

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

			// Enable GPS Toast
			Toast.makeText(getBaseContext(), "Enable Location Based Services",
					Toast.LENGTH_LONG).show();

			// Setting Particular Location
			CameraPosition cameraPosition = new CameraPosition.Builder()
					.target(new LatLng(12.9715987, 77.59456269999998)).zoom(9)
					.build();

			googleMap.animateCamera(CameraUpdateFactory
					.newCameraPosition(cameraPosition));

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}

	private void getLocation() {
		// Getting Google Play availability status
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getBaseContext());
		// Showing status
		if (status != ConnectionResult.SUCCESS) { // Google Play Services are
													// not available

			int requestCode = 10;
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this,
					requestCode);

			dialog.show();

		} else { // Google Play Services are available

			// Enabling MyLocation Layer of Google Map
			googleMap.setMyLocationEnabled(true);

			// Getting LocationManager object from System Service
			// LOCATION_SERVICE
			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

			// Creating a criteria object to retrieve provider
			Criteria criteria = new Criteria();

			// Getting the name of the best provider
			String provider = locationManager.getBestProvider(criteria, true);

			// Getting Current Location
			Location location = locationManager.getLastKnownLocation(provider);

			LocationListener locationListener = new LocationListener() {
				public void onLocationChanged(Location location) {
					// redraw the marker when get location update.
					drawMarker(location);
				}
			};
			if (location != null) {
				// PLACE THE INITIAL MARKER
				drawMarker(location);
			}
			locationManager.requestLocationUpdates(provider, 20000, 0,
					(android.location.LocationListener) locationListener);

		}
	}

	private void drawMarker(Location location) {
		googleMap.clear();
		LatLng currentPosition = new LatLng(location.getLatitude(),
				location.getLongitude());
		googleMap.addMarker(new MarkerOptions()
				.position(currentPosition)
				.snippet(
						"Lat:" + location.getLatitude() + "Lng:"
								+ location.getLongitude())
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
				.title("ME"));
	}

	void initilizeMarkers() {

		vidanaSoudha = new MarkerOptions().position(VIDANASOUDHA).title(
				"Vidana Soudha");
		vidanaSoudha.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
		googleMap.addMarker(vidanaSoudha);

		lalbagh = new MarkerOptions().position(LALBAGH).title("lalbagh");
		lalbagh.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
		googleMap.addMarker(lalbagh);

		cubbonPark = new MarkerOptions().position(CUBBONPARK).title(
				"cubbonPark");
		cubbonPark.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
		googleMap.addMarker(cubbonPark);

		bangalorePalace = new MarkerOptions().position(BANGALOREPALACE).title(
				"bangalorePalace");
		bangalorePalace.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
		googleMap.addMarker(bangalorePalace);

		tipuSultanPalace = new MarkerOptions().position(TIPUSULTANPALACE)
				.title("tipuSultanPalace");
		tipuSultanPalace.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
		googleMap.addMarker(tipuSultanPalace);

		ulsoorLake = new MarkerOptions().position(ULSOORLAKE).title(
				"ulsoorLake");
		ulsoorLake.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
		googleMap.addMarker(ulsoorLake);

		planetarium = new MarkerOptions().position(PLANETARIUM).title(
				"planetarium");
		planetarium.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_RED));
		googleMap.addMarker(planetarium);

		nationalPark = new MarkerOptions().position(NATIONALPARK).title(
				"nationalPark");
		nationalPark.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
		googleMap.addMarker(nationalPark);

		wonderLa = new MarkerOptions().position(WONDERLA).title("wonderLa");
		wonderLa.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
		googleMap.addMarker(wonderLa);

		nandiHills = new MarkerOptions().position(NANDIHILLS).title(
				"nandiHills");
		nandiHills.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
		googleMap.addMarker(nandiHills);

	}
}
