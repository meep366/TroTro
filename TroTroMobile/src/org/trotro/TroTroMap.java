package org.trotro;

import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class TroTroMap extends MapActivity {
	class Constants
	{
		public static final int ZOOM_STREET = 17;
		public static final int ZOOM_LOCALE = 15;
		public static final int ZOOM_CITY = 12;
	}
	
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.ghana);
		
		GeoPoint gpKumasi = new GeoPoint(6688477,-1618585);
		GeoPoint gpAccra = new GeoPoint(5561315,-189348);
		
		MapView mv = (MapView) findViewById(R.id.map);
		MapController mc = mv.getController();
		mc.setZoom(Constants.ZOOM_STREET);
		
		mc.animateTo(gpAccra);
	}
	
	@Override protected boolean isRouteDisplayed() { return false; }
}
