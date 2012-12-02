package org.trotro;

import java.util.ArrayList;

import org.trotro.Stop.Instance;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;

public class MapArea extends ItemizedOverlay<Stop.Instance> {

	public final static ArrayList<Stop.Instance> stops = new ArrayList<Stop.Instance>();
	public static MapView mapview;
	public static Stop.Instance currentLocation;
	public static AlertDialog.Builder currentPrompt;
	
	public MapArea(MapView mv) {
		super(Map.Constants.TRO_TRO);
		mv.getOverlays().add(this);
		mapview = mv;
	}

	@Override
	protected Instance createItem(int i) {
		Stop.Instance current = null; 
//		synchronized (stops) {		
			current = stops.get(i);
			Drawable marker = boundCenterBottom(current.getMarker());

			current.setMarker(marker);
//		}
		return current;
	}
	
	@Override
	protected boolean onTap(int index) {
		boolean value = super.onTap(index);
//		synchronized (stops) {

			try {			

				if (index >= stops.size())
					return false;
				currentLocation = stops.get(index);


				new Thread(new Runnable() {

					@Override
					public void run() {
						((Map)mapview.getContext()).runOnUiThread(new Runnable() {
							@Override public void run() {
								showDialog(R.id.stop);
							}
						});
					}
				}).start();
			}
			catch(Exception e) { Log.d(MapArea.class.getName(), e+""); }
//		}

		return value;
	}
	
	/**  PROMPTS FOR MAP */
	public void showDialog(int id) {
		try{
			switch(id) {
			case R.id.stop:
				currentPrompt = setUpPrompt(id);
	
				if(currentPrompt == null) return;
	
				currentPrompt.setOnCancelListener(new OnCancelListener() {
					@Override public void onCancel(DialogInterface dialog) {
						currentPrompt = setUpPrompt(Map.Constants.NO_DIALOG);
					}
				});
	
				checkForPrompt();		
				break;
			}
		}
		catch (Exception e) { Log.d(MapArea.class.getName(), e+""); }
	}

	@Override public int size() { return stops.size(); }
	
	public void add(Stop.Instance si) {

		try{
			
			stops.add(si);
			setLastFocusedIndex(-1);
			populate();
			
		} catch(Exception e){ Log.d(MapArea.class.getName(), e+""); }
	}
	
	public Builder setUpPrompt(int id) {
		switch(id) {

		case R.id.stop:
			final String details = currentLocation.getDetails()+"";

			return (Builder) new Builder(mapview.getContext())
			.setTitle(details)//"Stop:\t\t"+name+"\n"+details)
			.setIcon(R.drawable.ic_trotro_3)
			.setPositiveButton("Cancel", null)
			.setNeutralButton("Request Ride", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					//showDialog(R.id.ride_requested);
//					Intent intent = new Intent(context, ViewList.class);
//					intent.putExtra("list", Utility.toStringArray(currentSchedule.getAllTimes()));
//					context.startActivity(intent);
				}
			});

		default: return null;
		}
	}

	public void checkForPrompt() {
		if(currentPrompt != null)
			currentPrompt.show();
		
	}
}
