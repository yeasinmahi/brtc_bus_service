package com.sa223.brtcbusservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InternationalBusRoute extends Activity{
	int busId;
	TextView name,departureTime,offDay,fare;
	private void init(){
		Intent intent = getIntent();
		busId=(Integer) intent.getExtras().get("busId");
		name= (TextView) findViewById(R.id.busNameView);
		departureTime= (TextView) findViewById(R.id.departureTimeView);
		offDay= (TextView) findViewById(R.id.offDayView);
		fare= (TextView) findViewById(R.id.fareView);
	}
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.int_bus_route);
        init();
		populateList();
    }
	private void populateList() {
		if(busId==1){
			name.setText("Dhaka Kalkata International Service");
			departureTime.setText("7:00 am and 7:30 am (BST) ");
			offDay.setText("Sunday");
			fare.setText("BDT. 1500/-");
		}
		else{
			name.setText("Dhaka Agartala International Service");
			departureTime.setText("9:00 am (BST) ");
			offDay.setText("Sunday");
			fare.setText("BDT. 600/-");
		}
	}
}


