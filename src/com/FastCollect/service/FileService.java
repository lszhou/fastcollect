package com.FastCollect.service;

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
