package com.codingdojo.web.models;


import java.util.ArrayList;

public class Team {
	private String teamName;
	//We need to ultimately loop through a list of Players for each team...which means each Team needs to keep track of an array of Players
	private static int totalTeams = 0;
	private ArrayList<Player> players = new ArrayList<Player>();
	private int teamid;
	
	public Team(String name) {
		teamid = totalTeams++;
		this.teamName = name;
	}
	
	public int getId() {
		return this.teamid;
	}
	
	public String getName() {
		return this.teamName;
	}
	
	public void setName(String name) {
		this.teamName = name;
	}
	
	public void addPlayer(String firstName, String lastName, Integer age) {
		Player player = new Player(firstName, lastName, age);
		this.players.add(player);
	}
	
	//On the chance that our id is a string (which it always will be from the form)
	public void removePlayer(String id) {
		removePlayer(Integer.parseInt(id));
	}
	
	public void removePlayer(int id) {
		//ArrayLists use "size" and int[] or String[] (arrays) use .length
		for (int i =0; i < players.size(); i++) {
			//Because the id is private we need to use the get id method
			if (players.get(i).getid()== id) {
				//Use the built in array list method to remove the player
				players.remove(i);
			}
		}
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
}
