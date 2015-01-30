/*
 *设置save按钮
 *设置Next按钮
 */
package com.example.surveyapp;

import java.text.SimpleDateFormat;

import com.example.service.FileService;




import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button) this.findViewById(R.id.button);
		button.setOnClickListener(new ButtonClickListener());
		
	}
	
	//For the Button "START"
	public void openActivity01 (View v){
		Intent intent = new Intent();
		intent.setClass(this, question01.class);//设置要激活的组件
		startActivity(intent);
	}
	
	//for the button "SAVE"
	public class ButtonClickListener implements View.OnClickListener
	{
		public void onClick(View v) 
		{
			
			//EditText filenameText = (EditText) findViewById(R.id.filename);	
			//String filename = filenameText.getText().toString();
			
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String start = sDateFormat.format(new java.util.Date());
			
			FileService service = new FileService(getApplicationContext());
			try {
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
				{
					service.saveChiToSDCard(start);
					Toast.makeText(getApplicationContext(), R.string.success, 1).show();
				}
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), R.string.failure, 1).show();
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
