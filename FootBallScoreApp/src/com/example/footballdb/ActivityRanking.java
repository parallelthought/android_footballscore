package com.example.footballdb;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class ActivityRanking extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ranking, menu);
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
	public static class PlaceholderFragment extends ListFragment {
		
		private ArrayList<FootballModel> footballList;
		private FootballAdapter footballAdapter;
		private String URL="https://www.dein-weg-in-die-cloud.de/tomcat7/RestSoccer/fussball/tabelle";
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			View rootView = inflater.inflate(R.layout.fragment_ranking,
					container, false);

			initializeList();
			footballAdapter = new FootballAdapter(container.getContext(), R.layout.ranking_line_item, footballList);
			setListAdapter(footballAdapter);
					
			return rootView;
		}
		
		protected void initializeList(){
			
			String data=null ;
			JSONObject jsonObj;
			JSONObject entry;
			
			int id;
			String name;
			int tore;
			int punkte;
			int spiele;
			String logo;
			
			footballList = new ArrayList<FootballModel>();
			
			DownloadTask fetchJson = new DownloadTask();
			fetchJson.execute(URL);
			
			try {
				data = fetchJson.get();
				jsonObj = new JSONObject(data);
				JSONArray jsonArr = jsonObj.getJSONArray("tabelle");
				
				for (int i=1; i<=jsonArr.length(); i++){
					entry = jsonArr.getJSONObject(i);
					id = i;
					name = entry.getString("name");
					tore = Integer.parseInt(entry.getString("tore"));
					punkte = Integer.parseInt(entry.getString("punkte"));
					spiele = Integer.parseInt(entry.getString("spiele"));
					logo = entry.getString("logo");
					
					FootballModel team = new FootballModel(id, name, logo, tore, punkte, spiele);
					footballList.add(team);
				}
					
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
		}

	}

}
