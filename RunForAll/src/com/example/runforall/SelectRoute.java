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

public class SelectRoute extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_route);

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
		getMenuInflater().inflate(R.menu.select_route, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_select_route,
					container, false);
			return rootView;
		}
	}
	
	/**
	 * METHOD
	 * Van SelectRoute naar voorgeselecteerde route scherm
	 */
	public void toVoorgesteldeRoute(View view)
	{
		Intent intent = new Intent(this, VoorgesteldeRoute.class);
		startActivity(intent);
	}
	
	/**
	 * METHOD
	 * Van SelectRoute naar eigen route scherm
	 */
	public void toEigenRoute(View view)
	{
		Intent intent = new Intent(this, EigenRoute.class);
		startActivity(intent);
	}

}
