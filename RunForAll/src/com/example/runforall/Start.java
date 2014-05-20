package com.example.runforall;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class Start extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		 // Hide the actionbar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_start,
					container, false);
			return rootView;
		}
	}
	
	/**
	 * METHOD
	 * Van start naar startHardlopen scherm
	 */
	public void toSelectRoute(View view)
	{
		Intent intent = new Intent(this, SelectRoute.class);
		startActivity(intent);
	}
	
	/**
	 * METHOD
	 * Van start naar details scherm
	 */
	public void toDetails(View view)
	{
		Intent intent = new Intent(this, Details.class);
		startActivity(intent);
	}
	
	/**
	 * METHOD
	 * Van start naar berichten scherm
	 */
	public void toBerichten(View view)
	{
		Intent intent = new Intent(this, Berichten.class);
		startActivity(intent);
	}
	
	/**
	 * METHOD
	 * Van start naar instellingen scherm
	 */
	public void toInstellingen(View view)
	{
		Intent intent = new Intent(this, Instellingen.class);
		startActivity(intent);
	}

}
