package com.example.footballdb;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;

public class ActivityResult extends ActionBarActivity {
	
	private static int dateOfMatch = 23;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		this.setTitle("Results of the match day ");

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
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
		
		ArrayList<FootballResultModel> footballResultList;
		
		public PlaceholderFragment() {
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			
			FootballResultAdapter footballResultAdapter;
			
			View rootView = inflater.inflate(R.layout.fragment_result,
					container, false);
			
			JSONParser parse = new JSONParser();
			footballResultList = parse.results(dateOfMatch);
			
			footballResultAdapter = new FootballResultAdapter(container.getContext(), R.layout.result_line_item, footballResultList);
			setListAdapter(footballResultAdapter);
			
			return rootView;
		}
		
		public void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			
			System.out.println("This is the position ID " + footballResultList.get(position).getMatchID());
			
			Intent i = new Intent (v.getContext(), ResultDetailActivity.class);
			i.putExtra("matchID", footballResultList.get(position).getMatchID());
			startActivity(i);
		}

	}

}
