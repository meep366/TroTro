package org.trotro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class Place extends ContentProvider {

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
////	public final static class Table
////	{
////		// Database table
////		public static final String TABLE_STOP = "stops";
////		public static final String COLUMN_ID = "_id";
////		public static final String COLUMN_PROVIDER = "provider";
////		public static final String COLUMN_NAME = "name";
////
////		public static final String COLUMN_TFS = "tfs_key";
////		public static final String COLUMN_DESCRIPTION = "description";
////		public static final String COLUMN_ROUTES = "routes";
////		public static final String COLUMN_LAT = "lat";
////		public static final String COLUMN_LONG = "long";
////
////		
////		private static final String DATABASE_NAME = "stops.db";
////		private static final int DATABASE_VERSION = 1;
////		private static final String STOPS_TABLE = "stops";
//////
//////		// Column Names
//////		public static final String KEY_ID = "_id";
//////		public static final String KEY_NAME = "name";
//////		public static final String KEY_VICINITY = "vicinity";
//////		public static final String KEY_LOCATION_LAT = "latitude";
//////		public static final String KEY_LOCATION_LNG = "longitude";
//////		public static final String KEY_TYPES = "types";
//////		public static final String KEY_VIEWPORT = "viewport";
//////		public static final String KEY_ICON = "icon";
//////		public static final String KEY_REFERENCE = "reference";
//////		public static final String KEY_DISTANCE = "distance";
//////		public static final String KEY_LAST_UPDATE_TIME = "lastupdatetime";
////	}
////
////	public static class Instance extends OverlayItem implements android.os.Parcelable
////	{
////		private int _id;
////		private String routes[] = new String[0];
//////		private Utility.Provider provider;
//////		private Map<String,Connection.Instance> directions;
////
////		public Instance(GeoPoint point, String title, String snippet) {
////			super(point, title, snippet);
//////			directions=new HashMap<String, Connection.Instance>();
////		}
////
////		public Instance(Cursor cursor) {
////
////			this(new GeoPoint(
////					convertLat(cursor),convertLng(cursor)),
////					getName(cursor), "default: desc");
////
//////			_id = cursor.getInt(0);			
//////			provider = getTheProvider(cursor);
//////			routes = getRoutes(cursor, provider != Utility.Provider.GDOT_CAM);
////		}
////
////		public Instance(Parcel parcel) {
////			this(new GeoPoint(oneE6(parcel.readDouble()),
////					oneE6(parcel.readDouble())),
////					parcel.readString(), parcel.readString());
////
////			_id = parcel.readInt();
//////			provider = Utility.Provider.valueOf(parcel.readString());
//////			parcel.readStringArray(routes);
//////			parcel.readMap(directions, null);
////		}
////
////		public Instance(int newId, Provider personal, String name, String desc,
////				double lat, double lon) {
////			this(new GeoPoint(oneE6(lat),oneE6(lon)), name, desc);
////			this._id = newId;
//////			this.provider = personal;
////		}
////
////		@Override public int hashCode() { return _id; }
////		@Override public boolean equals(Object o) { return _id == o.hashCode(); }
////		@Override public int describeContents() { return 0; }
////
////		@Override
////		public void writeToParcel(Parcel dest, int flags) {
////			dest.writeDouble(mPoint.getLatitudeE6()/1E6);
////			dest.writeDouble(mPoint.getLongitudeE6()/1E6);
////			dest.writeString(mTitle);
////			dest.writeString(mSnippet);
////			dest.writeInt(_id);
//////			dest.writeString(provider+"");
////			dest.writeStringArray(routes);
//////			dest.writeMap(directions);
////		}
////
////		public Drawable getMarker() {
////			return new BitmapDrawable();
//////			switch(getProvider()) {
//////			case GDOT_CAM: return Utility.drawables[1];//;
//////			case INSTITUTION: return Utility.drawables[2];//;
//////			case ATTRACTIONS: return Utility.drawables[3];//;
//////			case CCT: return Utility.drawables[4];//cobbDrawable;
//////			case GCT: return Utility.drawables[5];//gwinnetteDrawable;
//////			case MARTA: return Utility.drawables[6];//martaDrawable;
//////			case RAIL: return Utility.drawables[7];//multiTransDrawable;
//////			case MULTI_T: return Utility.drawables[7];//multiTransDrawable;
//////			case BUSES: return Utility.drawables[8];//multiDrawable;
//////			case GOOGLE_SEARCH: return Utility.drawables[9];//placeDrawable;
//////			default: return Utility.drawables[10];//currentDrawable;
////			}
////		}
////
//////		public Connection.Instance getConnection(int which) {
//////			Connection.Instance route = directions.get(routes[which]);
//////			return route;
//////		}
//////
//////		public void add(String routeName, Connection.Instance connection) {
//////			directions.put(routeName, connection);	
//////		}
////
////		@Override
////		public String toString() {
////			return mTitle;
//////			return !"".equals(mTitle) ? 
//////			mTitle.replace(';', ',') 
//////			: ("_id "+ _id +" provider " 
//////			+provider +" routes " +routes);
////		}
////		
////		public int getId() { return _id; }
////		public String[] getRouteList() { return routes; }
//////		public Utility.Provider getProvider() { return provider; }
////		public Instance setRouteList(String[] strings) { routes = strings;  return this; }
////		public static int newId() { return -1;/*totalInternalPlaces;*/ }
////
////		public CharSequence getDetails() {
////			return mTitle +"\n"+ mSnippet +"\n"+ Utility.extractValues(routes);
////		}
////
////		public String getPointFormat() {
////			return mPoint.getLatitudeE6()/1E6+","+mPoint.getLongitudeE6()/1E6;
////		}
////
//////		public void changeValuesTo(atlanta.community.app.models.Google.Place p) {
//////			
//////			GeoPoint point = new GeoPoint(
//////				oneE6(p.geometry.location.lat),
//////				oneE6(p.geometry.location.lat));
//////			
//////			_id = Integer.parseInt(p.id);			
//////			provider = Utility.Provider.GOOGLE_SEARCH;
//////			routes = new String[]{};
//////		}
//	}
//
//	public static class Data extends SQLiteOpenHelper {
//
//		private static final int LOCALE = 0;
//		private static final int NAME_ID = 1;
//		private static final int LOCALE_ID = 2;
//		
//		public static boolean isFinished = true;
//		private static Context context;
//
//		/**
//		 * Constructor Takes and keeps a reference of the passed context in order to
//		 * access to the application assets and resources.
//		 * 
//		 * @param context
//		 */
//		public Data(Context context, String name, CursorFactory factory, int version) {
//			super(context, name, factory, version);
//			try {
//				Data.context = context;
//				createDataBase();
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			openDataBase();
//			new Crypt();
//		}
//
//		private Context getContext() { return context; }
//
//		private static String getData(String enc, boolean name)
//		{
//			if("".equals(enc)) 
//				return "";
//
//			return isFinished && name ? Crypt.getData(enc) : ""+((enc.contains("-") || enc.contains(","))?Crypt.getRoute(enc):Crypt.getName(enc));
//		}
//
//		private static int getIntData(String enc)
//		{
//			return isFinished ?  Integer.valueOf(Crypt.getIntData(enc)) : Crypt.getIntData(enc);
//		}
//
//		private static int getOtherIntData(String enc)
//		{
//			return isFinished ?  Integer.valueOf(Crypt.getOtherIntData(enc)) : Crypt.getOtherIntData(enc);
//		}
//
//		/**
//		 * Creates a empty database on the system and rewrites it with your own
//		 * secureDB.
//		 * */
//		public void createDataBase() throws IOException {
//
//			boolean dbExist = checkDataBase();
//
//			if (dbExist) {
//				// do nothing - database already exist
//			} else {
//
//				// By calling this method and empty database will be created into
//				// the default system path
//				// of your application so we are gonna be able to overwrite that
//				// database with our secureDB.
//				this.getReadableDatabase();
//
//				try {
//
//					copyDataBase();
//				} catch (IOException e) {
//
//					throw new Error("Error copying database");
//				}
//			}
//
//		}
//
//		/**
//		 * Check if the database already exist to avoid re-copying the file each
//		 * time you open the application.
//		 * 
//		 * @return true if it exists, false if it doesn't
//		 */
//		private boolean checkDataBase() {
//
//			SQLiteDatabase checkDB = null;
//
//			try {
//				checkDB = SQLiteDatabase.openDatabase(Table.DATABASE_PATH, null,
//						SQLiteDatabase.OPEN_READONLY);
//
//			} catch (SQLiteException e) {
//
//				// database does't exist yet.
//
//			}
//
//			if (checkDB != null) {
//
//				checkDB.close();
//
//			}
//
//			return checkDB != null ? true : false;
//		}
//
//		/**
//		 * Copies your database from your local assets-folder to the just created
//		 * empty database in the system folder, from where it can be accessed and
//		 * handled. This is done by transfering bytestream.
//		 * */
//		private void copyDataBase() throws IOException {
//
//			// Open your local db as the input stream
//			InputStream myInput = getContext().getAssets().open(Table.A_DATABASE_NAME);
//
//			// Path to the just created empty db
//			String outFileName = Table.DATABASE_PATH + Table.A_DATABASE_NAME;
//
//			// Open the empty db as the output stream
//			OutputStream myOutput = new FileOutputStream(outFileName);
//
//			// transfer bytes from the inputfile to the outputfile
//			byte[] buffer = new byte[1024];
//			int length;
//			while ((length = myInput.read(buffer)) > 0) {
//				myOutput.write(buffer, 0, length);
//			}
//
//			// Close the streams
//			myOutput.flush();
//			myOutput.close();
//			myInput.close();
//
//		}
//
//		public SQLiteDatabase openDataBase() throws SQLException {
//
//			// Open the database
//			getWritableDatabase();
//			return SQLiteDatabase.openDatabase(Table.DATABASE_PATH+Table.A_DATABASE_NAME, null,
//					SQLiteDatabase.OPEN_READONLY);
//		}
//
//		@Override
//		public synchronized void close() {
//
//			if (getWritableDatabase() != null)
//				getWritableDatabase().close();
//
//			super.close();
//
//		}
//
//
//		private static final class Crypt
//		{	
//			private static BigInteger one = new BigInteger("1");
//			private static BigInteger twelve = new BigInteger("12");
//			private static BigInteger publicKey, phi, mod;
//			private static String 
//			ppp = "1455514367995526881240427135592852261820185574840430684405053779308047092865709429538623", 
//			qqq = "1853657375633442959438931647017046821074052591607737356527654281522698368948781619414759";
//
//			public Crypt() {
//
//				publicKey  = new BigInteger("65537");//30000000000000000000000029");
//			}
//
//			public static String getRoute(String value) {
//				StringBuilder sb = new StringBuilder();
//
//				int length = value.length();
//
//				for (int i = 0; i < length; i++) {
//					try{ 
//						int asciiValue = value.charAt(i);
//						if(asciiValue >= 48 && asciiValue <= 57)
//							sb.append(""+mapping((char) asciiValue));
//						else if(asciiValue >= 65 && asciiValue <= 90)
//							sb.append(""+mapping((char) asciiValue));
//						else if(asciiValue >= 97 && asciiValue <= 122)
//							sb.append(""+mapping((char) asciiValue));
//						else
//							sb.append(""+((char) asciiValue));
//					}
//					catch(Exception e) { e.printStackTrace(); }
//				}
//
//				return sb.toString();
//			}
//
//			private static char mapping(char value) throws UnsupportedEncodingException {
//				String Alphabet  ="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//				String Cryptabet ="GDYZALVSPMJXFNWORBKCIUQEHT9753102468gdyzalvspmjxfnworbkciuqeht";
//				int alphaVal = Cryptabet.indexOf(value);
//				int convert = -1;
//
//				if(alphaVal == -1)
//					throw new UnsupportedEncodingException(value +" value not in map.");
//				else convert = alphaVal;
//
//				return Alphabet.charAt(convert);
//			}
//
//			public static String getName(String enc) {
//
//				return new String(new BigInteger(enc).subtract(twelve).divide(twelve).toByteArray());
//			}
//
//			private static String getData(String encryptedData) {
//
//				BigInteger data = new BigInteger(encryptedData);
//				return new String(data.modPow(publicKey.modInverse(getPhi()), getModulus()).toByteArray());
//			}
//
//			private static int getOtherIntData(String encryptedData) {
//
//				int value = Integer.parseInt(encryptedData);
//				value *= 12;
//				value += 12;
//				return value;
//			}
//
//			private static int getIntData(String encryptedData) {
//
//				int value = Integer.parseInt(encryptedData);
//				value -= 12;
//				value /= 12;
//				return value;
//			}
//
//			private static BigInteger getModulus() {
//				if(mod == null)
//				{
//					mod = new BigInteger(ppp).multiply(new BigInteger(qqq));
//				}
//				return mod;
//			}
//
//			private static BigInteger getPhi() {
//				if(phi == null)
//				{
//					phi = (new BigInteger(ppp).subtract(one)).multiply(new BigInteger(qqq).subtract(one));						//				phi = (p.subtract(one)).multiply(q.subtract(one));					
//				}
//				return phi;
//			}	
//		}
//
//		@Override public void onCreate(SQLiteDatabase db) { }
//		@Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
//	}
//	
//	public static class ExternalData extends SQLiteOpenHelper {
//		private static final String DATABASE_CREATE =
//				"create table " + Table.STOPS_TABLE + " (" 
//						+ Table.KEY_ID + " TEXT primary key, "
//						+ Table.KEY_NAME + " TEXT, "
//						+ Table.KEY_VICINITY + " TEXT, "
//						+ Table.KEY_LOCATION_LAT + " FLOAT, "
//						+ Table.KEY_LOCATION_LNG + " FLOAT, "
//						+ Table.KEY_TYPES + " TEXT, "
//						+ Table.KEY_VIEWPORT + " TEXT, "
//						+ Table.KEY_ICON + " TEXT, "
//						+ Table.KEY_REFERENCE + " TEXT, "
//						+ Table.KEY_DISTANCE + " FLOAT, "
//						+ Table.KEY_LAST_UPDATE_TIME + " LONG); ";
//
//		public ExternalData(Context context, String name, CursorFactory factory, int version) {
//			super(context, name, factory, version);
//		}
//
//		@Override
//		public void onCreate(SQLiteDatabase db) {
//			db.execSQL(DATABASE_CREATE);           
//		}
//
//		@Override
//		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//			String message = 
//				"Upgrading database from version " + oldVersion 
//				+ " to " + newVersion + ", which will destroy all old data";
//			Utility.report(AtlantaCommunity.Instance(), message, false); 
//
//			db.execSQL("DROP TABLE IF EXISTS " + Table.STOPS_TABLE);
//			onCreate(db);
//		}
//	
//		public static final int ALL_PLACES = 3;
//		public static final int PLACE_ID = 4;
//		public static final int PLACES = 5;
//	}
//
//	// THE BUCK STOPS HERE!!!
//	public static int oneE6(double d){ return (int)(1E6 * d); }
//
//	public static int convertLat(Cursor cursor){ 
//
//		double stop_la = cursor.getDouble(cursor.getColumnIndex(Table.COLUMN_LAT));
//		switch(cursor.getInt(0) % 4)
//		{
//		case 0: stop_la -= 1.1; break;
//		case 1: stop_la += 1.7; break;
//		case 2: stop_la -= 0.9; break;
//		case 3: stop_la += 1.2; break;
//		}
//		return oneE6(stop_la); 
//	}
//
//	public static int convertLng(Cursor cursor){ 
//
//		double stop_lo = cursor.getDouble(cursor.getColumnIndex(Table.COLUMN_LONG));
//		switch(cursor.getInt(0) % 4)
//		{
//		case 0: stop_lo += 1.2; break;
//		case 1: stop_lo -= 2.0; break;
//		case 2: stop_lo += 1.3; break;
//		case 3: stop_lo -= 1.5; break;
//		}
//		return oneE6(stop_lo); 
//	}
//
//	public static Utility.Provider getTheProvider(Cursor cursor)
//	{
//		String data = Data.getData(cursor.getString(
//				cursor.getColumnIndex(Table.COLUMN_PROVIDER)), false);
//		switch (data.charAt(0)) {
//		case 'R':
//			data = "RAIL";
//			break;
//		case 'M':
//			if(data.charAt(1) == 'A')
//				data = "MARTA";
//			else data = "MULTI_T";
//			break;
//		case 'C':
//			data = "CCT";
//			break;
//		case 'G':
//			if(data.charAt(1) == 'C')
//				data = "GCT";
//			else data = "GDOT_CAM";
//			break;
//		case 'A':
//			data = "ATTRACTIONS";
//			break;
//		case 'B':
//			data = "BUSES";
//			break;
//		case 'I':
//			data = "INSTITUTION";
//			break;
//		case 'X':
//			data = "XPRESS";
//			break;
//		case 'P':
//			if(data.charAt(1) == 'R')
//				data = "PARK_RIDE";
//			else if(data.charAt(1) == 'C')
//				data = "PARK_COVERED";
//			else if(data.charAt(1) == 'G')
//				data = "PARK_GARAGE";
//			else
//				data = "PARKING";
//			break;
//		default:
//			data = "PERSONAL";
//
//		}
//
//		return Utility.Provider.valueOf(data);
//	}
//
//	public static String getName(Cursor cursor)
//	{
//		return Data.getData(cursor.getString(
//				cursor.getColumnIndex(Table.COLUMN_NAME)), false);
//	}
//
//	public static int getSource(String value)
//	{
//		return Data.getOtherIntData(value);
//	}
//
//	public static String[] getRoutes(Cursor cursor, boolean isTransitRoute)
//	{
//		String r = "";
//		String value = cursor.getString(
//				cursor.getColumnIndex(Table.COLUMN_ROUTES));
//
//		String list[] = value.split(",");
//		if(!"".equals(list[0]) && isTransitRoute)
//		{
//			for (String string : list) {
//				string = Data.getData(string, false);
//				r = getRoute(r, list, string);
//			}
//		}
//		else
//		{
//			return Data.getData(value, false).split("\n");
//		}
//
//		return r.split(",");
//	}
//
//	private static String getRoute(String r, String[] list, String string) {
//		if (!"".equals(string)) {
//
//			String val[] = string.split("-");
//			String newString = "";
//
//			switch (val[0].charAt(0)) {
//			case 'R':
//				newString = "RAIL";
//				break;
//			case 'M':
//				newString = "MARTA";
//				break;
//			case 'C':
//				newString = "CCT";
//				break;
//			case 'G':
//				newString = "GCT";
//				break;
//			case 'A':
//				newString = "ATTRACTIONS";
//				break;
//			}
//
//			newString += " " + val[1] + " ";
//			switch (val[2].charAt(0)) {
//			case 'i':
//				newString += "in";
//				break;
//			case 'o':
//				newString += "out";
//				break;
//			case 'n':
//				newString += "north";
//				break;
//			case 's':
//				newString += "south";
//				break;
//			case 'e':
//				newString += "east";
//				break;
//			case 'w':
//				newString += "west";
//				break;
//			}
//
//			newString += " ";
//			switch (val[3].charAt(1)) {
//			case 'e':
//				newString += "weekday";
//				break;
//			case 'a':
//				newString += "saturday";
//				break;
//			case 'u':
//				newString += "sunday";
//				break;
//			case 'o':
//				newString += "holiday";
//				break;
//			}
//
//			r += (r.length() <= 1 ? "" : ",") + newString;
//		}
//		return r;
//	}
//
//	public static Connection.Instance toConnection(Cursor cursor) {
//
//		String toBeId = cursor.getString(cursor.getColumnIndex(Connection.Table.COLUMN_ROUTE_ID));
//		String value = Data.getData(cursor.getString(cursor.getColumnIndex(Connection.Table.COLUMN_ROUTE)), false);
//
//		String route =  getRoute("", new String[]{ value }, value);
//		int routeId = Integer.parseInt(new String(new BigInteger(toBeId).subtract(Data.Crypt.twelve).divide(Data.Crypt.twelve).toByteArray()));//Integer.parseInt(/*Data.getData(*/toBeId/*, false)*/);
//
//		int source = Data.getIntData(cursor.getString(cursor.getColumnIndex(Connection.Table.COLUMN_SOURCE)));
//		int dest = Data.getIntData(cursor.getString(cursor.getColumnIndex(Connection.Table.COLUMN_DEST)));
//		int s_mins = Data.getIntData(cursor.getString(cursor.getColumnIndex(Connection.Table.COLUMN_S_MINS)));
//		int d_mins = Data.getIntData(cursor.getString(cursor.getColumnIndex(Connection.Table.COLUMN_D_MINS)));
//
//		Connection.Instance conn = new Connection.Instance(route, routeId, source, dest, s_mins, d_mins);
//
//		return conn;
//	}
//
//	public static Instance setUpPlace(Cursor c, String name) {
//		int table_col_id = c.getColumnIndex(Table.KEY_ID);
//		int id = c.getInt(table_col_id);
//
//		int table_col_provider = c.getColumnIndex(Table.KEY_TYPES);
//		String prov = c.getString(table_col_provider);
//		Utility.Provider provider = Provider.valueOf(prov);
//		
//		int table_col_desc = c.getColumnIndex(Table.KEY_VIEWPORT);
//		String desc = c.getString(table_col_desc);
//
//		int table_col_lat = c.getColumnIndex(Table.KEY_LOCATION_LAT);
//		double lat = c.getDouble(table_col_lat);
//		
//		int table_col_lon = c.getColumnIndex(Table.KEY_LOCATION_LNG);
//		double lon = c.getDouble(table_col_lon);
//
//		int table_col_route = c.getColumnIndex(Table.KEY_VICINITY);
//		String message = c.getString(table_col_route);
//		
//		Instance stop = new Instance(id,provider,name,desc,lat,lon);
//		stop.setRouteList(new String[]{ message });
//		
//		return stop;
//	}
//	
//	// CONTENT PROVIDER CONSTANTS
//	public static final String AUTHORITY = Utility.Constants.APPLICATION+".models.place.provider";
//	public static final String SEARCH_SUGGEST = "search_suggest_query";
//
//	public static final String BASE_PATH = "locales";
//	public static final String COORDINATES = BASE_PATH+"/coordinates";
//	public static final String PLACES_PATH = "places";
//
//	public static final Uri CONTENT_URI_ID = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
//	public static final Uri CONTENT_URI_COORDINATES = Uri.parse("content://" + AUTHORITY + "/" + COORDINATES);
//	public static final Uri CONTENT_URI_COORDINATES_EXT = Uri.parse("content://" + AUTHORITY + "/" + PLACES_PATH);
//	public static BigInteger twelve = new BigInteger("12");
//	
//    /**
//     * The columns we'll include in our search suggestions.  There are others that could be used
//     * to further customize the suggestions, see the docs in {@link SearchManager} for the details
//     * on additional columns that are supported.
//     */
//    public static final String[] COLUMNS = {
//            BaseColumns._ID,  // must include an _id column
//            SearchManager.SUGGEST_COLUMN_TEXT_1,
//            SearchManager.SUGGEST_COLUMN_TEXT_2,
//            SearchManager.SUGGEST_COLUMN_INTENT_DATA,
//    };
//    
//	/** The underlying database */
//	private static SQLiteDatabase placesDB;
//	private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
//
//	static {
//		
//		sURIMatcher.addURI(AUTHORITY, COORDINATES+"/*", Data.LOCALE);
//		sURIMatcher.addURI(AUTHORITY, BASE_PATH+"/#", Data.LOCALE_ID);
//		sURIMatcher.addURI(AUTHORITY, SEARCH_SUGGEST+"/*", Data.NAME_ID);
//
//		sURIMatcher.addURI(AUTHORITY, PLACES_PATH, ExternalData.ALL_PLACES);
//		sURIMatcher.addURI(AUTHORITY, PLACES_PATH+"/*", ExternalData.PLACES);
//		sURIMatcher.addURI(AUTHORITY, PLACES_PATH+"/#", ExternalData.PLACE_ID);
//	}
//
//	@Override
//	public boolean onCreate() {
//		Context context = getContext();
//		ExternalData dbHelper = new ExternalData(context, Table.B_DATABASE_NAME, null, Table.DATABASE_VERSION);
//		try {
//			placesDB = dbHelper.getWritableDatabase();
//		} catch (SQLiteException e) {
//			placesDB = null;
//			Utility.report(AtlantaCommunity.Instance(), e, true);
//		}
//
//		return (placesDB == null) ? false : true;
//	}
//
//	@Override
//	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
//
//		int uriType = sURIMatcher.match(uri);
//		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
//		boolean isExternal = uriType == ExternalData.ALL_PLACES || uriType == ExternalData.PLACE_ID || uriType == ExternalData.PLACES;
//		
//		switch (uriType) {
//		case Data.LOCALE:
//			processLocaleFromCoordinates(uri, queryBuilder);
//			break;
//			
//		case Data.LOCALE_ID:
//			return processIdFromSearchResult(uri, queryBuilder);
//			
//		case Data.NAME_ID:
//			return processLocaleFromCharacters(uri, queryBuilder);
//			
//		case ExternalData.ALL_PLACES:
//			queryBuilder.setTables(Table.STOPS_TABLE);
//			break;
//			
//		case ExternalData.PLACES:
//			processPlaceFromCoordinates(uri, queryBuilder);
//			break;
//			
//		case ExternalData.PLACE_ID:
//			queryBuilder.setTables(Table.STOPS_TABLE);
//			queryBuilder.appendWhere(Table.KEY_ID + "=" + uri.getLastPathSegment());
//			break;
//		}
//
//		return getContent(uri, projection, selection, selectionArgs, sortOrder, queryBuilder, isExternal);
//	}
//
//	@Override 
//	public Uri insert(Uri _uri, ContentValues _initialValues) {
//		long rowID = placesDB.insert(Table.STOPS_TABLE, "nullhack", _initialValues);
//
//		if (rowID > 0) {
//			Uri uri = ContentUris.withAppendedId(CONTENT_URI_COORDINATES_EXT, rowID);
//			getContext().getContentResolver().notifyChange(uri, null);
//			return uri;
//		}
//		throw new SQLException("Failed to insert row into " + _uri);
//	}
//	
//	@Override 
//	public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
//		int count;
//		switch (sURIMatcher.match(uri)) {
//		case ExternalData.PLACES: count = placesDB.update(Table.STOPS_TABLE, values, where, whereArgs);
//		break;
//
//		case ExternalData.PLACE_ID: String segment = uri.getLastPathSegment();
//		count = placesDB.update(Table.STOPS_TABLE, values, Table.KEY_ID 
//				+ "=" + segment 
//				+ (!TextUtils.isEmpty(where) ? " AND (" 
//						+ where + ')' : ""), whereArgs);
//		break;
//
//		default: throw new IllegalArgumentException("Unknown URI " + uri);
//		}
//
//		getContext().getContentResolver().notifyChange(uri, null);
//		return count;
//	}
//
//	@Override 
//	public int delete(Uri uri, String where, String[] whereArgs) {
//		int count;
//
//		switch (sURIMatcher.match(uri)) {
//		case ExternalData.PLACES:
//			count = placesDB.delete(Table.STOPS_TABLE, where, whereArgs);
//			break;
//
//		case ExternalData.PLACE_ID:
//			String segment = uri.getLastPathSegment();
//			count = placesDB.delete(Table.STOPS_TABLE, Table.KEY_ID + "="
//					+ segment
//					+ (!TextUtils.isEmpty(where) ? " AND (" 
//							+ where + ')' : ""), whereArgs);
//			break;
//
//		default: throw new IllegalArgumentException("Unsupported URI: " + uri);
//		}
//
//		getContext().getContentResolver().notifyChange(uri, null);
//		return count;
//	}
//
//	// SUBORDINATE METHODS TO QUERY
//	private Cursor getContent(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, SQLiteQueryBuilder queryBuilder, boolean external) {
//		Cursor cursor = null;
//		
//		if(external)
//		{
//			// If no sort order is specified sort by date / time
//			String orderBy;
//			if (TextUtils.isEmpty(sortOrder)) 
//				orderBy = Table.KEY_DISTANCE + " ASC"; 
//			else orderBy = sortOrder;
//
//			cursor = queryBuilder.query(placesDB, projection, selection, selectionArgs, null, null, orderBy);
//		}
//		else
//		{
//			Place.Data localeDatabase = AtlantaCommunity.Instance().getLocaleData();
//			
//			cursor = queryBuilder.query(localeDatabase.getWritableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);
//		}
//
//		// Make sure that potential listeners are getting notified
//		cursor.setNotificationUri(getContext().getContentResolver(), uri);
//
//		return cursor;
//	}
//
////	private String checkSettingsForVisibility() {
////		String selection;
////		String CCT =  new BigInteger("CC".getBytes()).multiply(twelve).add(twelve).toString(),
////			MARTA =  new BigInteger("MA".getBytes()).multiply(twelve).add(twelve).toString(),
////			GCT =  new BigInteger("GC".getBytes()).multiply(twelve).add(twelve).toString(),
////			GDOT = new BigInteger("GD".getBytes()).multiply(twelve).add(twelve).toString();
////
////		 
////		SharedPreferences sp = Utility.Preferences();
////		boolean showTransit = sp.getBoolean(getContext().getString(R.string.KEY_PROVIDER_TRANSIT), false);
////		boolean showCameras = sp.getBoolean(getContext().getString(R.string.KEY_PROVIDER_GDOT), false);
////		
////		if(!showTransit && !showCameras)
////			selection = Table.COLUMN_PROVIDER +"=''";
////		else selection = "";
////		
////		if (showTransit){
////			selection += Table.COLUMN_PROVIDER +"='"+CCT+"'";
////			selection += " OR "+ Table.COLUMN_PROVIDER +"='"+MARTA+"'";
////			selection += " OR "+ Table.COLUMN_PROVIDER +"='"+GCT+"'";
////		}
////		if (showCameras) 
////			selection += (selection.length() == 0 ? "":" OR ")+Table.COLUMN_PROVIDER +"='"+GDOT+"'";
////		return selection;
////	}
//
//	private Cursor processIdFromSearchResult(Uri uri, SQLiteQueryBuilder queryBuilder) {
//		queryBuilder.setTables(Table.TABLE_STOP);
//		String value = uri.getLastPathSegment();
//
//		Place.Data localeDatabase = AtlantaCommunity.Instance().getLocaleData();
//		
//		Cursor cursor = queryBuilder.query(localeDatabase.getWritableDatabase(), null, Table.COLUMN_ID + "=" + value, null, null, null, null);
//
//		// Make sure that potential listeners are getting notified
//		cursor.setNotificationUri(getContext().getContentResolver(), uri);
//
//		return cursor;
//	}
//	
//	private void processLocaleFromCoordinates(Uri uri, SQLiteQueryBuilder queryBuilder) {
//		queryBuilder.setTables(Table.TABLE_STOP);
//		String values[] = uri.getLastPathSegment().split(",");
//
//		int iter = Integer.parseInt(values[0]);
//		
//		final double orgLat = Double.parseDouble(values[1]);
//		final double orgLon = Double.parseDouble(values[2]);
//		final double threshold = Double.parseDouble(values[3]);
//		double lat, lon; 
//
//		switch(iter % 4) {
//		case 0: lat = orgLat + 1.1; lon = orgLon - 1.2; break;
//		case 1: lat = orgLat - 1.7; lon = orgLon + 2.0; break;
//		case 2: lat = orgLat + 0.9; lon = orgLon - 1.3; break;
//		default: lat = orgLat - 1.2; lon = orgLon + 1.5; break;
//		}
//
//		double north = lat + threshold;
//		double south = lat - threshold;
//		double east = lon + threshold;
//		double west = lon - threshold;
//
//		//queryBuilder.appendWhere(checkSettingsForVisibility()+" and ");
//		queryBuilder.appendWhere(Table.COLUMN_LAT + " between " + south + " and " + north
//			+" and " + Table.COLUMN_LONG + " between " + west +" and "+ east);
//	}
//
//	private void processPlaceFromCoordinates(Uri uri, SQLiteQueryBuilder queryBuilder) {
//		queryBuilder.setTables(Table.STOPS_TABLE);
//		String values[] = uri.getLastPathSegment().split(",");
//
//		double orgLat = Double.parseDouble(values[0]);
//		double orgLon = Double.parseDouble(values[1]);
//		double threshold = Utility.Constants.LOCAL_STOPS_SEARCH_THRESHOLD_CAPACITY;
//
//		double north = orgLat + threshold;
//		double south = orgLat - threshold;
//		double east = orgLon + threshold;
//		double west = orgLon - threshold;
//
//		queryBuilder.appendWhere(Table.KEY_LOCATION_LAT + " between " + south + " and " + north
//			+" and " + Table.KEY_LOCATION_LNG + " between " + west +" and "+ east);
//	}
//	
//	private MatrixCursor processLocaleFromCharacters(final Uri uri, SQLiteQueryBuilder queryBuilder) {
//		queryBuilder.setTables(Table.TABLE_STOP);
//		
//		String value = uri.getLastPathSegment();
//
//		final MatrixCursor matrixCursor = new MatrixCursor(COLUMNS);
//		if("unknown".equals(value)) return matrixCursor;
//
//		try { value = encryptIt(value); }
//		catch (UnsupportedEncodingException e) { e.printStackTrace(); }
//			
//		String selection = Table.COLUMN_TFS + " LIKE '%" + value +"%'";
//		
//		// Check if the caller has requested a column which does not exists
//		SQLiteDatabase db = null;
//		Data localeDatabase = AtlantaCommunity.Instance().getLocaleData();
//		
//		
//		db = localeDatabase.getWritableDatabase();
//		queryBuilder.appendWhere(selection);
//		
//		final Cursor cursor = queryBuilder.query(db, null, null,
//				null, null, null, null);
//		// Make sure that potential listeners are getting notified
//		cursor.setNotificationUri(getContext().getContentResolver(), uri);
//
//		final int length = cursor.getCount();
//		cursor.moveToFirst();
//		
//		boolean isShort = length <= 20;
//		boolean canContinue = true;
//		
//		for (int iter = 0; canContinue && (!isShort || iter < length); iter++) {
//
//			String id = ""+cursor.getInt(cursor.getColumnIndex(Table.COLUMN_ID));
//			String name = getName(cursor);
//			Provider provider = getTheProvider(cursor);
//			String desc = Utility.extractValues(getRoutes(cursor, provider != Provider.GDOT_CAM));
//
//			matrixCursor.addRow(new Object[]{ id, name, desc, id });
//			cursor.moveToNext();
//			canContinue = iter < 20;
//		}
//		
//		
//		return matrixCursor;
//	}
//	
//	public String encryptIt(String value) throws UnsupportedEncodingException {
//
//		StringBuilder sb = new StringBuilder();
//		value = parseQuery(value);
//		
//		int length = value.length();
//
//		for (int i = 0; i < length; i++) {
//			int asciiValue = value.charAt(i);
//			if(asciiValue >= 97 && asciiValue <= 122)
//				sb.append(""+mapping((char) asciiValue));
//		}
//
//		return sb.toString();
//	}
//
//	public static String parseQuery(String value) {
//		value = value.toLowerCase();
//
//		value = value.replaceAll("station", "stn");
//		value = value.replaceAll(" ", "");
//		value = value.replaceAll("a", "");
//		value = value.replaceAll("e", "");
//		
//		for (char component : value.toCharArray()) {
//			int occurrence  = value.indexOf(""+component+component);
//			if(occurrence >= 0)
//				value = value.replaceAll(""+component+component,""+component);
//		}
//		
//		return value;
//	}
//
//	private char mapping(char value) throws UnsupportedEncodingException {
//		String Alphabet  ="abcdefghijklmnopqrstuvwxyz";
//		String Cryptabet ="THEQUICKBROWNFXJMPSVLAZYDG";
//		
//		int alphaVal = Alphabet.indexOf(value);
//		int convert = -1;
//		
//		if(alphaVal == -1) 
//			throw new UnsupportedEncodingException(value +" value not in map.");
//		else convert = alphaVal;
//		
//		return Cryptabet.toLowerCase().charAt(convert);
//	}
//
//	@Override public String getType(Uri uri) { return null; }
}
