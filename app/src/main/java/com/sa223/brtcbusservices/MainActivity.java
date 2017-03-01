package com.sa223.brtcbusservices;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

   
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PopulatedOpenHelper.getInstance(getApplicationContext());
    }

    public void city(View v){
    	Intent intentMain = new Intent(MainActivity.this, BusList.class);
		MainActivity.this.startActivity(intentMain);
		Log.i("Content ", " Main layout ");
    }
    public void interDrictict(View v){
    	Intent intentSearch = new Intent(MainActivity.this, InterCityBusList.class);
		//intentSearch.putExtra("sql", sql);
		MainActivity.this.startActivity(intentSearch);
    }
    public void international(View v){
    	Intent intentSearch = new Intent(MainActivity.this, InternationalBusList.class);
		//intentSearch.putExtra("sql", sql);
		MainActivity.this.startActivity(intentSearch);
    }
    public void school(View v){
    	/*Intent intentSearch = new Intent(MainActivity.this, BusList.class);
		intentSearch.putExtra("sql", sql);
		MainActivity.this.startActivity(intentSearch);*/
    	Toast.makeText(getApplicationContext(), "Not Avaiable Right Now", Toast.LENGTH_LONG).show();
    }
}
