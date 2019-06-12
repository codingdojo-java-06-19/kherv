package com.codingdojo.web.models;


import java.util.ArrayList;



public class Roster {
	//A roster needs to be able to loop through all of the teams and pull out their attributes.
	//We could have multiple rosters that could hold multiple teams (i.e. West Coast vs. East Coast teams...etc)
	private ArrayList<Team> teams = new ArrayList<Team>();

	//We don't need  initilization information because we've defined it as an ArrayList of Teams above
	public Roster() {
	}
	
	public ArrayList<Team> getTeams(){
		return this.teams;
	}
	
	public Team getOneTeam(String id) {
		return getOneTeam(Integer.parseInt(id));
	}
	
	public Team getOneTeam(int id) {
		for (int i=0; i<teams.size(); i++) {
			if (teams.get(i).getId()==id) {
			return teams.get(i);
			}
		}
		return null;
	}
	
	public void addTeam(String teamName) {
		Team team = new Team(teamName);
		addTeam(team);
	}
	
	public void addTeam(Team thisTeam) {
		this.teams.add(thisTeam);
	}

	
	public void removeTeam(int id) {
		for (int i=0; i<teams.size(); i++ ){
			if (teams.get(i).getId()==id) {
				this.teams.remove(i);
			}
		}
	}
	
	public void removeTeam(String id) {
		removeTeam(Integer.parseInt(id));
	}
	
	public void removePlayerFromTeam(String teamId, String playerId) {
		removePlayerFromTeam(Integer.parseInt(teamId), Integer.parseInt(playerId));
	}
	
	public void removePlayerFromTeam(int teamId, int playerId) {
		getOneTeam(teamId).removePlayer(playerId);

	}
	
	
}
