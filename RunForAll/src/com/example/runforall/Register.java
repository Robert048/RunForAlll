package com.example.runforall;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends Activity implements OnClickListener{

	private EditText user, pass, pass2, birth, country, weight, length, email;
	//private RadioButton gender1;
	//private RadioGroup gender;
	private Button  mRegister;

	 // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();

    //php login script

    //localhost :
    //testing on your device
    //put your local ip instead,  on windows, run CMD > ipconfig
    //or in mac's terminal type ifconfig and look for the ip under en0 or en1
   // private static final String LOGIN_URL = "http://xxx.xxx.x.x:1234/webservice/register.php";

    //testing on Emulator:
    private static final String LOGIN_URL = "http://runforall.samba-ti.nl/register.php";

  //testing from a real server:
    //private static final String LOGIN_URL = "http://www.yourdomain.com/webservice/register.php";

    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		user = (EditText)findViewById(R.id.EditText1);
		birth = (EditText)findViewById(R.id.EditText2);
		email = (EditText)findViewById(R.id.EditText3);
		country = (EditText)findViewById(R.id.EditText4);
		pass = (EditText)findViewById(R.id.EditText5);
		pass2 = (EditText)findViewById(R.id.EditText6);
		length = (EditText)findViewById(R.id.EditText7);
		weight = (EditText)findViewById(R.id.EditText8);		
		//gender = (RadioGroup) findViewById(R.id.gender); 
		

		mRegister = (Button)findViewById(R.id.button1);
		mRegister.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

				new CreateUser().execute();

	}

	class CreateUser extends AsyncTask<String, String, String> {

		 /**
         * Before starting background thread Show Progress Dialog
         * */
		boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Register.this);
            pDialog.setMessage("Registreren...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

		@Override
		protected String doInBackground(String... args) {
			// TODO Auto-generated method stub
			 // Check for success tag
            int success;
            //int selected = gender.getCheckedRadioButtonId();
    		//gender1 = (RadioButton)findViewById(selected);
            String username = user.getText().toString();
            String emailadres = email.getText().toString();
            String password = pass.getText().toString();
            String password2 = pass2.getText().toString();
            String birthdate = birth.getText().toString();
            String land = country.getText().toString();
            String lengte = length.getText().toString();
            String gewicht = weight.getText().toString();
            //String geslacht = gender1.getText().toString();
            
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));
                params.add(new BasicNameValuePair("password2", password2));
                params.add(new BasicNameValuePair("emailadres", emailadres));
                params.add(new BasicNameValuePair("birhtdate", birthdate));
                params.add(new BasicNameValuePair("land", land));                
                params.add(new BasicNameValuePair("lengte", lengte));
                params.add(new BasicNameValuePair("gewicht", gewicht));
               // params.add(new BasicNameValuePair("geslacht", geslacht));


                Log.d("request!", "starting");

                //Posting user data to script
                JSONObject json = jsonParser.makeHttpRequest(
                       LOGIN_URL, "POST", params);

                // full json response
                Log.d("Login attempt", json.toString());

                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                	Log.d("User Created!", json.toString());
                	finish();
                	return json.getString(TAG_MESSAGE);
                }else{
                	Log.d("Login Failure!", json.getString(TAG_MESSAGE));
                	return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

		}
		/**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
            	Toast.makeText(Register.this, file_url, Toast.LENGTH_LONG).show();
            }

        }

	}

}