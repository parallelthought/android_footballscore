package com.example.footballdb;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class ImageDownload extends AsyncTask<String, Void, Bitmap> {

	@Override
	protected Bitmap doInBackground(String... params) {
		
		Bitmap bmp = null;
		
		java.net.URL myUrl;
		try {
			myUrl = new java.net.URL (params[0]);
			InputStream in = myUrl.openStream();
			bmp = BitmapFactory.decodeStream(in);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bmp;
		
	}
}
