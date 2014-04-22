package com.example.footballdb;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class FootballResultAdapter extends ArrayAdapter<FootballResultModel> {

	private ArrayList<FootballResultModel> items;
	
	public FootballResultAdapter(Context context, int resource, ArrayList<FootballResultModel> items) {
		
		super(context, resource, items);
		if(items != null){
			this.items = items;
		} else {
			this.items = new ArrayList<FootballResultModel>();
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return super.getView(position, convertView, parent);
	}
	
	

}
