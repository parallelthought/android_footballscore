package com.example.footballdb;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FootballAdapter extends ArrayAdapter<FootballModel> {

	private ArrayList<FootballModel> items;
	
	public FootballAdapter(Context context,  int textViewID,  ArrayList<FootballModel> items){
		
		super(context, textViewID, items);
		if(items != null){
			this.items = items;
		} else {
			this.items = new ArrayList<FootballModel>();
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = li.inflate(R.layout.ranking_line_item, null);
		
		FootballModel item = items.get(position);
		
		TextView tvID = (TextView) convertView.findViewById(R.id.tvID);
		tvID.setText(String.valueOf(item.getId()));
		
		ImageView ivLogo = (ImageView) convertView.findViewById(R.id.ivLogo);
		ImageDownload idt = new ImageDownload();
		String logoUrl = convertView.getResources().getString(R.string.serverUrl) + item.getTeamIconUrl(); 
		idt.execute(logoUrl);
		try {
			ivLogo.setImageBitmap(idt.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		TextView tvName = (TextView) convertView.findViewById(R.id.tvTeamName);
		tvName.setText(String.valueOf(item.getTeamName()));
		
		TextView tvPoints = (TextView) convertView.findViewById(R.id.tvPoints);
		tvPoints.setText(String.valueOf(item.getPoints()));
		
		TextView tvGoals = (TextView) convertView.findViewById(R.id.tvGoals);
		tvGoals.setText("+" + String.valueOf(item.getGoalDifference()));
		
		TextView tvPlace = (TextView) convertView.findViewById(R.id.tvPlaceb);
		tvPlace.setText(String.valueOf(item.getPlace()));
		
		return convertView;
	}
	
	
}
