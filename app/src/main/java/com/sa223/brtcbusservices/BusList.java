package com.sa223.brtcbusservices;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class BusList extends ListActivity{
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_list);
        SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.custom_row, new String[] { "name"}, new int[] { R.id.text1});
		populateList();
		setListAdapter(adapter);
    }
	static final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	
	private void populateList() {
		DbHelper dbHelper = new DbHelper(getApplicationContext());
		ArrayList<Bus> buss = dbHelper.getBusList();
		list.clear();
		for (Bus bus : buss) {
			HashMap<String, String> temp = new HashMap<String, String>();
			temp.put("id", bus.getBusId());
			temp.put("name", bus.getBusName());
			list.add(temp);
		}
	}
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		try {
			Intent intentMain = new Intent(BusList.this, BusRoute.class);
			int busId=Integer.parseInt(list.get(position).get("id"));
			intentMain.putExtra("busId", busId);
			BusList.this.startActivity(intentMain);
		} 
		catch (Exception e) {
			
		}
	}
}


