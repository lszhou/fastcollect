package com.example.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.R.string;
import android.content.Context;
import android.os.Environment;
import android.support.v7.internal.widget.ContentFrameLayout;

public class FileService {
	private Context context;
	
	public FileService(Context context) {
		super();
		this.context = context;
	}
	
/*	public void saveToSDCard(String filename, String content) throws Exception
	{
		File file = new File(new File("/mnt/sdcard"),filename);
		FileOutputStream outputStream = new FileOutputStream(file);
		outputStream.write(content.getBytes());
		outputStream.close();
	}*/

	/*
	 * save data to local file.
	 */
	/*public void save(String filename, String content) throws Exception
	{
		// java IO
		//Private MODE, the created file is only available to this application. The content will be overrided.
		FileOutputStream outputStream = context.openFileOutput(filename, Context.MODE_APPEND);
		outputStream.write(filename.getBytes());
		outputStream.close();
		
	}*/

	public void saveChiToSDCard(String chi) throws Exception
	{
		File externalStorageDir = Environment.getExternalStorageDirectory();
		File myFile = new File(externalStorageDir, "surveyData.txt");

		if(myFile.exists())
		{
		       FileOutputStream fOut = new FileOutputStream(myFile,true);
		       OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
		       myOutWriter.append(chi);
		       myOutWriter.close();
		       fOut.close();
		}
		else
		{
		    myFile.createNewFile();
		    FileOutputStream fOut = new FileOutputStream(myFile);
		    OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
		    myOutWriter.append(chi);
		    myOutWriter.close();
		    fOut.close();
		}
	}
	

}
