package com.example.runforall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class OverzichtVrienden extends Activity {
	// Adapter
	SimpleAdapter simpleAdpt;
	// The data to show
	List<Map<String, String>> vrienden = new ArrayList<Map<String, String>>();

	private void initList() {
		// Add friends to Array (Komt straks uit Db)
		vrienden.add(addFriends("vrienden", "Bertin van den Ham"));
		vrienden.add(addFriends("vrienden", "Alex de Jonge"));
		vrienden.add(addFriends("vrienden", "Edwin Slot"));
		vrienden.add(addFriends("vrienden", "Martijn Jansen"));
		vrienden.add(addFriends("vrienden", "Xing Woo"));
		vrienden.add(addFriends("vrienden", "a van den Ham"));
		vrienden.add(addFriends("vrienden", "b de Jonge"));
		vrienden.add(addFriends("vrienden", "c Slot"));
		vrienden.add(addFriends("vrienden", "d Jansen"));
		vrienden.add(addFriends("vrienden", "e Woo"));
		vrienden.add(addFriends("vrienden", "f van den Ham"));
		vrienden.add(addFriends("vrienden", "g de Jonge"));
		vrienden.add(addFriends("vrienden", "h Slot"));
		vrienden.add(addFriends("vrienden", "i Jansen"));
		vrienden.add(addFriends("vrienden", "j Woo"));
		vrienden.add(addFriends("vrienden", "k van den Ham"));
		vrienden.add(addFriends("vrienden", "l de Jonge"));
		vrienden.add(addFriends("vrienden", "m Slot"));
		vrienden.add(addFriends("vrienden", "n Jansen"));
		vrienden.add(addFriends("vrienden", "o Woo"));		
	}

	private HashMap<String, String> addFriends(String key, String name) {
		HashMap<String, String> vriend = new HashMap<String, String>();
		vriend.put(key, name);

		return vriend;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_overzicht_vrienden);

		// Hide the actionbar
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		initList();

		// We get the ListView component from the layout
		ListView lv = (ListView) findViewById(R.id.listView);

		// This is a simple adapter that accepts as parameter
		// Context
		// Data list
		// The row layout that is used during the row creation
		// The keys used to retrieve the data
		// The View id used to show the data. The key number and the view id
		// must match
		simpleAdpt = new SimpleAdapter(
		this, // context
		vrienden, // datalist
		//android.R.layout.simple_list_item_1, // simple layout
		R.layout.stylelistview, // custom layout
		new String[] { "vrienden" },  // the keys to retrieve the data
		new int[] { R.id.Text1 }); // key number and the view id

		lv.setAdapter(simpleAdpt);
		
		// we register for the contextmneu       
		registerForContextMenu(lv);
	}
	
	// We want to create a context Menu when the user long click on an item
	  @Override
	  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) 
	  {
	      super.onCreateContextMenu(menu, v, menuInfo);
	      AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

	      // We know that each row in the adapter is a Map
	      HashMap map =  (HashMap) simpleAdpt.getItem(aInfo.position);

	      // Header context popup menu
	      menu.setHeaderTitle("Options voor " + map.get("vrienden"));
	      // Options
	      menu.add(1, 1, 1, "Blokkeren");
	      menu.add(1, 2, 2, "Verwijderen");

	  }	
	  
	// This method is called when user selects an Item in the Context menu
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		// Implements our logic
		Toast.makeText(this, "Item id [" + itemId + "]", Toast.LENGTH_SHORT).show();
		return true;
	}  
}
