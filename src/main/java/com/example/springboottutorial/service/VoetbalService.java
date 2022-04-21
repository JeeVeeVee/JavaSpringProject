package com.example.springboottutorial.service;

import com.example.springboottutorial.domain.WedstrijdTicket;

import java.util.List;

public interface VoetbalService {

	public List<String> getStadiumList();

	public List<WedstrijdTicket> getWedstrijdenByStadium(String stadium);

	public WedstrijdTicket getWedstrijd(String id);

	public int ticketsBestellen(String id, int teBestellen);

}