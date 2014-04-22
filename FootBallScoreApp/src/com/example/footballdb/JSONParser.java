package com.example.footballdb;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

	protected ArrayList<FootballResultModel> Results(){
		
		String resultURL = "https://www.dein-weg-in-die-cloud.de/tomcat7/RestSoccer/fussball/spieltag/23";
		
		ArrayList<FootballResultModel> footballResultList;
		String data=null ;
		JSONObject mainJSONObj;
		JSONObject teamOneJSONObj;
		JSONObject teamTwoJSONObj;
		
		JSONArray mainJSONArr;
		JSONArray teamOneJSONArr;
		JSONArray teamTwoJSONArr;
		JSONObject entry;
		
		int teamOneTore;
		String teamOneName;
		String teamOneLogo;
		
		int teamTwoTore;
		String teamTwoName;
		String teamTwoLogo;
		
		footballResultList = new ArrayList<FootballResultModel>();
		
		DownloadTask fetchJson = new DownloadTask();
		fetchJson.execute(resultURL);
		
		try {
			data = fetchJson.get();
			mainJSONObj = new JSONObject(data);
			mainJSONArr = mainJSONObj.getJSONArray("tabelle");

			for(int j=0; j<=mainJSONArr.length();j++){
				entry = mainJSONArr.getJSONObject(j);
				teamOneJSONObj = entry.getJSONObject("team1"); 
				teamTwoJSONObj = entry.getJSONObject("team2");
				
				teamOneName = teamOneJSONObj.getString("name");
				teamOneLogo = teamOneJSONObj.getString("logo");
				teamOneTore = teamOneJSONObj.getInt("tore");
				
				teamTwoName = teamTwoJSONObj.getString("name");
				teamTwoLogo = teamTwoJSONObj.getString("logo");
				teamTwoTore = teamTwoJSONObj.getInt("tore");
				
				FootballResultModel teams = new FootballResultModel();
				teams.setTeamOneLogo(teamOneLogo);
				teams.setTeamOneName(teamOneName);
				teams.setTeamOneTore(teamOneTore);
				teams.setTeamTwoLogo(teamTwoLogo);
				teams.setTeamTwoName(teamTwoName);
				teams.setTeamTwoTore(teamTwoTore);
				
				footballResultList.add(teams);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		return footballResultList;
		
	}
	
	protected ArrayList<FootballModel> Ranking(){
		
		String URL="https://www.dein-weg-in-die-cloud.de/tomcat7/RestSoccer/fussball/tabelle";
		
		ArrayList<FootballModel> footballList;
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
		
		return footballList;
	}
	
}
