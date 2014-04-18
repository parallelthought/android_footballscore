package com.example.footballdb;

public class FootballModel {
	
	private int id;
	private int place;
	private String teamIconUrl;
	private String teamName;
	private int goalDifference;
	private int points;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public String getTeamIconUrl() {
		return teamIconUrl;
	}
	public void setTeamIconUrl(String teamIconUrl) {
		this.teamIconUrl = teamIconUrl;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getGoalDifference() {
		return goalDifference;
	}
	public void setGoalDifference(int goalDifference) {
		this.goalDifference = goalDifference;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public FootballModel (int id, String teamName, String logoURL, int tore, int punkte, int spiele){
		 this.id = id;
		 this.teamName = teamName;
		 this.teamIconUrl = logoURL;
		 this.goalDifference = tore;
		 this.points = punkte;
		 this.place = spiele;
	}
	
}
