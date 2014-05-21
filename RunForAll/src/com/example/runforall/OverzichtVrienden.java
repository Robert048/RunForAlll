package com.example.runforall;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OverzichtVrienden extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_overzicht_vrienden);

		// Hide the actionbar
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		String[] vrienden = new String[] { "Kimberly Hamers", "Martijn Jansen",
				"Xing Woo", "Edwin Slot", "Alex de Jonge" };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, 								    // context for the activity
				//android.R.layout.simple_list_item_1,  // layout to use
				R.layout.stylelistview,  				// layout to use
				vrienden);							    // items to be displayed
		
		// reference
		ListView list = (ListView)findViewById(R.id.listView);
		list.setAdapter(adapter);
	}
}
