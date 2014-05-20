package com.example.runforall;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

public class Register extends Activity {
	// Fields
	private ProgressDialog pDialog;
	 

   JSONParser jsonParser = new JSONParser();
    
    //gebruikersnaam
   static EditText inputGebruikersNaam;
    //geslacht
   static  RadioButton inputCheckMan;
   static  RadioButton inputCheckVrouw;
    //geboortedatum
   static EditText inputGeboortedatum;
    //e-mail
   static EditText inputEmail;
    //land
   static EditText inputLand;
    //wachtwoord1
   static EditText inputWachtwoord1;
    //wachtwoord2
   static EditText inputWachtwoord2;
    //lengte
   static EditText inputLengte;
    //gewicht
   static EditText inputGewicht;
    
    private static String url_register = "http://inf1g_runforall.samba-ti.nl/register.php";
        
    private static final String TAG_SUCCESS = "success";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_register);

		
        // Hide the actionbar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		
		//Edit Text
		inputGebruikersNaam = (EditText) findViewById(R.id.EditText1);
		inputCheckMan = (RadioButton) findViewById(R.id.checkBox1);
		inputCheckVrouw = (RadioButton) findViewById(R.id.checkBox2);
		inputGeboortedatum = (EditText) findViewById(R.id.EditText2);
		inputEmail = (EditText) findViewById(R.id.EditText3);
		inputLand = (EditText) findViewById(R.id.EditText4);
		inputWachtwoord1 = (EditText) findViewById(R.id.EditText5);
		inputWachtwoord2 = (EditText) findViewById(R.id.EditText6);
		inputLengte = (EditText) findViewById(R.id.EditText7);
		inputGewicht = (EditText) findViewById(R.id.EditText8);
		
		
		setContentView(R.layout.activity_register);
		
		// Check witch checkbox is checked (Only one checkbox can be checked)
		

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	public void loadFiles(View view)
	{
		EenLeukeNaam obj = new EenLeukeNaam();
		obj.execute();
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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

			View rootView = inflater.inflate(R.layout.fragment_register, container,
					false);
			return rootView;
		}
	}	
	public class EenLeukeNaam extends AsyncTask<String, String, String> {
	
		@Override
		protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(Register.this);
        pDialog.setMessage("Registreren..");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }
		
		@Override
	protected String doInBackground(String... args) {
        String gebruikersnaam = inputGebruikersNaam.getText().toString();
        String geboortedatum = inputGeboortedatum.getText().toString();
        String email = inputEmail.getText().toString();
        String land = inputLand.getText().toString();
        String wachtwoord1 = inputWachtwoord1.getText().toString();
        String wachtwoord2 = inputWachtwoord2.getText().toString();
        String lengte = inputLengte.getText().toString();
        String gewicht = inputGewicht.getText().toString();

        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("gebruikersnaam", gebruikersnaam));
        params.add(new BasicNameValuePair("geboortedatum", geboortedatum));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("land", land));
        params.add(new BasicNameValuePair("wachtwoord1", wachtwoord1));
        params.add(new BasicNameValuePair("wachtwoord2", wachtwoord2));
        params.add(new BasicNameValuePair("lengte", lengte));
        params.add(new BasicNameValuePair("gewicht", gewicht));
        
        // getting JSON Object
        // Note that create product url accepts POST method
        JSONObject json = jsonParser.makeHttpRequest("http://inf1grunforall.samba-ti.nl/register.php",
                "POST", params);
        System.out.println(json);

        // check log cat fro response
        Log.d("Create Response", json.toString());
        System.out.println(" log");
        // check for success tag
        try {
            int success = json.getInt(TAG_SUCCESS);

            if (success == 1) {
                // successfully created product
            	System.out.println(json + " succes");

                // closing this screen
                
            } 
            else 
            {
            	System.out.println(json + " failed");
                // failed to create product
            }
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println(json + " catch");
        }
        return null;
	}
	
		@Override
	 protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            super.onPostExecute(file_url);
            
            if(pDialog.isShowing()) 
            {
            	pDialog.dismiss();
            }
            	
	 }
		
	}	

} // end class
