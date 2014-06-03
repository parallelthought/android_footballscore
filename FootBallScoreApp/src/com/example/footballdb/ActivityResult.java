package com.example.footballdb;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.os.Build;

public class ActivityResult extends ActionBarActivity {
	
	public static int dateOfMatch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		ViewPager mPager = (ViewPager) findViewById(R.id.pager); 
		ScreenSlidePagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager()); 
		mPager.setAdapter(mPagerAdapter); 
		mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { 
			@Override 
			public void onPageSelected(int position) { 
				//invalidateOptionsMenu(); 
				} 
			});
		
		dateOfMatch = getIntent().getIntExtra("matchDay",2);
		System.out.println("Date of the match is " + dateOfMatch);
		
		this.setTitle("Results of the match day " + dateOfMatch);

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
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

		public static PlaceholderFragment create(int matchday) { 
			PlaceholderFragment fragment = new PlaceholderFragment(); 
			Bundle args = new Bundle(); 
			args.putInt("ARG_MATCHDAY", matchday); 
			fragment.setArguments(args); 
			return fragment; 
		}
		
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			FootballResultAdapter footballResultAdapter;
			
			View rootView = inflater.inflate(R.layout.fragment_result,
					container, false);
			
			//ListView listView = new ListView(mActivity);
			
			
			JSONParser parse = new JSONParser();
			footballResultList = parse.results(dateOfMatch);
			
			footballResultAdapter = new FootballResultAdapter(container.getContext(), R.layout.result_line_item, footballResultList);
			setListAdapter(footballResultAdapter);
			
			//Button objects
			Button previousBtn = (Button) rootView.findViewById(R.id.ResultActPreviousBtn);
			Button nextBtn = (Button) rootView.findViewById(R.id.ResultActNextBtn);
			
			//Previous Button on click listeners
			previousBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int matchDay = dateOfMatch - 1;
					Intent i = new Intent (v.getContext(), ActivityResult.class);
					i.putExtra("matchDay", matchDay);
					startActivity(i);
				}
			});
			
			//Previous Button on click listeners
			nextBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int matchDay = dateOfMatch + 1;
					Intent i = new Intent (v.getContext(), ActivityResult.class);
					i.putExtra("matchDay", matchDay);
					startActivity(i);
				}
			});
			
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
