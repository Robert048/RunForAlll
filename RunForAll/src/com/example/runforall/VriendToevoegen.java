package com.example.runforall;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class VriendToevoegen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vriend_toevoegen);

		// Hide the actionbar
		ActionBar actionBar = getActionBar();
		actionBar.hide();

	}
}
