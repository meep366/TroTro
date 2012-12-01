package org.trotro;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class Map extends MapActivity {
	static class Constants {
		public static final int ZOOM_STREET = 17;
		public static final int ZOOM_LOCALE = 15;
		public static final int ZOOM_CITY = 12;
		public static Drawable TRO_TRO;
		
		public void Loader(Context context)
		{
			TRO_TRO = context.getResources().getDrawable(R.drawable.ic_trotro_3);
		}
	}
	
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.ghana);
		
		//GeoPoint gpKumasi = new GeoPoint(6688477,-1618585);
		GeoPoint gpAccra = new GeoPoint(5561315,-189348);
		
		MapView mv = (MapView) findViewById(R.id.map);
		MapController mc = mv.getController();
		mc.setZoom(Constants.ZOOM_STREET);
		
		mc.animateTo(gpAccra);
	}
	
	@Override protected boolean isRouteDisplayed() { return false; }
}
