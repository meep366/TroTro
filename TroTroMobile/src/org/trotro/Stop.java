package org.trotro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class Stop extends ContentProvider {

	@Override
	public boolean onCreate() {
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public final static class Table
	{
		// Database table
		public static final String TABLE_STOP = "stops";
		public static final String COLUMN_ID = "_id";
		public static final String COLUMN_PROVIDER = "provider";
		public static final String COLUMN_NAME = "name";

		public static final String COLUMN_DESCRIPTION = "description";
		public static final String COLUMN_ROUTES = "routes";
		public static final String COLUMN_LAT = "lat";
		public static final String COLUMN_LONG = "long";
		
//		private static final String DATABASE_NAME = "stops.db";
//		private static final int DATABASE_VERSION = 1;
//		private static final String STOPS_TABLE = "stops";
	}

	public static class Instance extends OverlayItem implements android.os.Parcelable
	{
		private int _id;

		public Instance(GeoPoint point, String title, String snippet) {
			super(point, title, snippet);
		}

		public Instance(Cursor cursor) {

			this(new GeoPoint(
				convertLat(cursor),
				convertLng(cursor)),
				getName(cursor),
				"default: desc");

			_id = cursor.getInt(0);
		}

		public Instance(Parcel parcel) {
			this(new GeoPoint(oneE6(parcel.readDouble()),
					oneE6(parcel.readDouble())),
					parcel.readString(), parcel.readString());

			_id = parcel.readInt();
		}

		public Instance(int newId, 
			String name, String desc,
			double lat, double lon) {
			
			this(new GeoPoint(oneE6(lat),oneE6(lon)), name, desc);
			this._id = newId;
		}

		@Override public int hashCode() { return _id; }
		@Override public boolean equals(Object o) { return _id == o.hashCode(); }
		@Override public int describeContents() { return 0; }

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeDouble(mPoint.getLatitudeE6()/1E6);
			dest.writeDouble(mPoint.getLongitudeE6()/1E6);
			dest.writeString(mTitle);
			dest.writeString(mSnippet);
			dest.writeInt(_id);
		}

		public Drawable getMarker() {
			return Map.Constants.TRO_TRO;//new BitmapDrawable();
		}

		@Override
		public String toString() {
			return mTitle;
		}
		
		public int getId() { return _id; }
		
		public CharSequence getDetails() {
			return mTitle +"\n"+ mSnippet;
		}

		public String getPointFormat() {
			return mPoint.getLatitudeE6()/1E6+","+mPoint.getLongitudeE6()/1E6;
		}
	}



	public static String getName(Cursor cursor)
	{
		return cursor.getString(
			cursor.getColumnIndex(
					Table.COLUMN_NAME));
	}
	
	public static int oneE6(double d){ return (int)(1E6 * d); }

	public static int convertLat(Cursor cursor){ 

		double stop_la = cursor.getDouble(cursor.getColumnIndex(Table.COLUMN_LAT));
		switch(cursor.getInt(0) % 4)
		{
		case 0: stop_la -= 1.1; break;
		case 1: stop_la += 1.7; break;
		case 2: stop_la -= 0.9; break;
		case 3: stop_la += 1.2; break;
		}
		return oneE6(stop_la); 
	}

	public static int convertLng(Cursor cursor){ 

		double stop_lo = cursor.getDouble(cursor.getColumnIndex(Table.COLUMN_LONG));
		switch(cursor.getInt(0) % 4)
		{
		case 0: stop_lo += 1.2; break;
		case 1: stop_lo -= 2.0; break;
		case 2: stop_lo += 1.3; break;
		case 3: stop_lo -= 1.5; break;
		}
		return oneE6(stop_lo); 
	}

	public static class Data extends SQLiteOpenHelper {
		private static final String DATABASE_CREATE =
			"create table " + Table.TABLE_STOP + " (" 
				+ Table.COLUMN_ID + " TEXT primary key, "
				+ Table.COLUMN_LAT + " TEXT, "
				+ Table.COLUMN_LONG + " TEXT); ";

		public Data(Context context, String name, CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);           
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			String message = 
				"Upgrading database from version " + oldVersion 
				+ " to " + newVersion + ", which will destroy all old data";
			
			Log.d(Stop.class.getName(), message);
			
			db.execSQL("DROP TABLE IF EXISTS " + Table.TABLE_STOP);
			onCreate(db);
		}
	}
}
