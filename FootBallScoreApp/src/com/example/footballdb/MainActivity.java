package com.example.footballdb;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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
        
        switch(item.getItemId()){
    		case android.R.id.home:
    			NavUtils.navigateUpFromSameTask(this);
    		return true;
        }
        
        if (id == R.id.action_settings) {
            return true;
        }
                
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            Button btnRanking = (Button) rootView.findViewById(R.id.btnRanking);
            Button btnResult = (Button) rootView.findViewById(R.id.btnResult);
            
            btnRanking.setOnClickListener(new View.OnClickListener() {
				
            	//onClick and opening of Intent or a new view
				@Override
				public void onClick(View v) {
					Intent i = new Intent (v.getContext(), ActivityRanking.class);
					startActivity(i);
				}
			});
            
            //Code for action on button click for results
            btnResult.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent (v.getContext(), ActivityResult.class);
					i.putExtra("matchDay", 22);
					startActivity(i);
				}
			});
            		
            return rootView;
        }
    }

}
