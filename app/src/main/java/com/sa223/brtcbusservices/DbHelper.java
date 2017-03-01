package com.sa223.brtcbusservices;

import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	private static final String dbName = "brtcBusService";
	private static final int version = 1;
	public DbHelper(Context context) {
		super(context, dbName, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Route> getRoute( int busId) {
		ArrayList<Route> routes = new ArrayList<Route>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query("routeView", null, "busId=?", new String[]{""+busId}, null, null,
				null);
		if (cursor != null && cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Route route = new Route();
				String routeId = cursor.getString(cursor
						.getColumnIndex("routeId"));
				String location = cursor.getString(cursor
						.getColumnIndex("location"));
				route.setRouteId(routeId);
				route.setLocation(location);
				routes.add(route);
			}
		}
		cursor.close();
		db.close();
		return routes;
	}
	public ArrayList<Bus> getBusList() {
		ArrayList<Bus> buss = new ArrayList<Bus>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query("bus", null, null, null, null, null,
				null);
		if (cursor != null && cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Bus bus = new Bus();
				String busId = cursor.getString(cursor
						.getColumnIndex("busId"));
				String busName = cursor.getString(cursor
						.getColumnIndex("busName"));
				bus.setBusId(busId);
				bus.setBusName(busName);
				buss.add(bus);
			}
		}
		cursor.close();
		db.close();
		return buss;
	}
	public ArrayList<Bus> getInterCityBusList() {
		ArrayList<Bus> buss = new ArrayList<Bus>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query("intercitybus", null, null, null, null, null,
				null);
		if (cursor != null && cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Bus bus = new Bus();
				String busId = cursor.getString(cursor
						.getColumnIndex("busId"));
				String busName = cursor.getString(cursor
						.getColumnIndex("busName"));
				bus.setBusId(busId);
				bus.setBusName(busName);
				buss.add(bus);
			}
		}
		cursor.close();
		db.close();
		return buss;
	}
	public ArrayList<Route> getInterCityRoute( int busId) {
		ArrayList<Route> routes = new ArrayList<Route>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query("interCityRouteView", null, "busId=?", new String[]{""+busId}, null, null,
				null);
		if (cursor != null && cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Route route = new Route();
				String routeId = cursor.getString(cursor
						.getColumnIndex("routeId"));
				String location = cursor.getString(cursor
						.getColumnIndex("location"));
				route.setRouteId(routeId);
				route.setLocation(location);
				routes.add(route);
			}
		}
		cursor.close();
		db.close();
		return routes;
	}
}
