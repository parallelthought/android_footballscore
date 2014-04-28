package com.example.footballdb;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
		
		ImageDownload idt ;
		String logoUrl;
		
		LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = li.inflate(R.layout.result_line_item, null);
		
		FootballResultModel item = items.get(position);
		
		TextView tvTeamOneName = (TextView) convertView.findViewById(R.id.tvDetailResultTeamOneName);
		tvTeamOneName.setText(String.valueOf(item.getTeamOneName()));
		
		ImageView ivTeamOneLogo = (ImageView) convertView.findViewById(R.id.ivTeamOneLogo);
		idt = new ImageDownload();
		logoUrl = convertView.getResources().getString(R.string.resultURL) + item.getTeamOneLogo(); 
		idt.execute(logoUrl);
		try {
			ivTeamOneLogo.setImageBitmap(idt.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		TextView tvTeamOneScore = (TextView) convertView.findViewById(R.id.tvTeamOneScore);
		tvTeamOneScore.setText(String.valueOf(item.getTeamOneTore()));
		
		TextView tvTeamTwoScore = (TextView) convertView.findViewById(R.id.tvTeamTwoScore);
		tvTeamTwoScore.setText(String.valueOf(item.getTeamTwoTore()));
		
		ImageView ivTeamTwoLogo = (ImageView) convertView.findViewById(R.id.ivTeamTwoLogo);
		idt = new ImageDownload();
		logoUrl = convertView.getResources().getString(R.string.resultURL) + item.getTeamTwoLogo(); 
		idt.execute(logoUrl);
		try {
			ivTeamTwoLogo.setImageBitmap(idt.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		TextView tvTeamTwoName = (TextView) convertView.findViewById(R.id.tvTeamTwoName);
		tvTeamTwoName.setText(String.valueOf(item.getTeamTwoName()));
		
		return convertView;
	}
	
	

}
