package com.example.footballdb;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import android.os.AsyncTask;

public class DownloadTask extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... params) {
		
		String data=null;
		HttpResponse response ;
		
		for(String param : params){
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(param);
			try{
				response = client.execute(httpget);
				HttpEntity entity = response.getEntity();
				if(entity != null){
					data = EntityUtils.toString(entity);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}


}
