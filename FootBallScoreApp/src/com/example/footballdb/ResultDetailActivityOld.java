/*package com.example.footballdb;
package com.example.footballdb;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;

public class ResultDetailActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_detail);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result_detail, menu);
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

	*//**
	 * A placeholder fragment containing a simple view.
	 *//*
	 
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_result_detail,
					container, false);
			
			Bundle args = getArguments();
			
			DownloadTask dt = new DownloadTask();
			dt.execute(" " + args.getInt("match_day") + "/bericht/" + args.getInt("match_id"));
			
			String result;
			ResultDetailModel myModel;
			
			try{
				result = dt.get();
				JSONParser parser = new JSONParser();
				myModel = parser.parseResultDetail(result);
				mapModel2View(rootView,myModel);
				
			} catch (Exception e){
				e.printStackTrace();
			}
			
			return rootView;
		}

		private void mapModel2View(View rootView, ResultDetailModel myModel) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
*/