package com.example.surveyapp;

import java.text.SimpleDateFormat;

import com.example.service.FileService;
import com.example.surveyapp.MainActivity.ButtonClickListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Audio.Radio;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class question04 extends Activity {
	
	TextView textview;
	RadioGroup radiogroup;
	RadioButton radio1, radio2, radio3;
	String chi;
	
	@Override
	protected void onCreate (Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity04);
		Button button2 = (Button) this.findViewById(R.id.button2);
		button2.setOnClickListener(new ButtonClickListener());
	      
        radiogroup=(RadioGroup)findViewById(R.id.radioGroup);  
        radio1=(RadioButton)findViewById(R.id.radioButton1);  
        radio2=(RadioButton)findViewById(R.id.radioButton2);  
        radio3=(RadioButton)findViewById(R.id.radioButton3); 
        
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) 
			{
				// TODO Auto-generated method stub
				if (checkedId == radio1.getId())
				{
					//save choice 1
					chi=", 1";
				}
				else if (checkedId == radio2.getId())
				{
					//save choice 2
					chi=", 2";
				}
				else if (checkedId == radio3.getId())
				{
					//save choice 3
					chi=", 3";
				}
				else
				{
					Toast.makeText(getApplicationContext(), R.string.select, Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	public void openActivity08 (View v){
		Intent intent = new Intent();
		intent.setClass(this, question08.class);//设置要激活的组件
		startActivity(intent);
	}
	
	private class ButtonClickListener implements View.OnClickListener
	{
		public void onClick(View v) 
		{
			
			FileService service = new FileService(getApplicationContext());
			try {
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
				{
					service.saveChiToSDCard(chi);
					Toast.makeText(getApplicationContext(), R.string.success, 1).show();
				}
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), R.string.failure, 1).show();
				e.printStackTrace();
			}
			
		}
	}

}


