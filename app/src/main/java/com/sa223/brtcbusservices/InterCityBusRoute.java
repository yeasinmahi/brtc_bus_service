package com.sa223.brtcbusservices;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class InterCityBusRoute extends ListActivity{
	int busId;
	private void init(){
		Intent intent = getIntent();
		busId=(Integer) intent.getExtras().get("busId");
	}
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.bus_route);
        SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.custom_row, new String[] { "name"}, new int[] { R.id.text1});
		populateList();
		setListAdapter(adapter);
		
    }
	static final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	
	private void populateList() {
		DbHelper dbHelper = new DbHelper(getApplicationContext());
		ArrayList<Route> routes = dbHelper.getInterCityRoute(busId);
		list.clear();
		for (Route route : routes) {
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("id", route.getRouteId());
			temp.put("name", route.getLocation());
			list.add(temp);
		}
	}
}


