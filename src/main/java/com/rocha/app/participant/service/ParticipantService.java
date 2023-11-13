package com.rocha.app.participant.service;

import java.io.IOException;
import java.net.http.HttpResponse;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.rocha.app.http.module.HttpModuleClient;
import com.rocha.app.model.Participant;

public class ParticipantService {

	public static void registerParticipant(int numberParticipant, String URL) throws IOException, InterruptedException {
		
		makeRequest(numberParticipant, URL);
	}
	
	private static void  makeRequest(int numberParticipant, String URL) throws IOException, InterruptedException {
		HttpModuleClient httpClient = new HttpModuleClient();
		Faker feku = new Faker();
		Gson gson = new Gson();
		Participant p = new Participant();
		p = getParticipant(p);
		
		for (int i = 0; i < numberParticipant; i++) {
			
			p.setEmail(getRamdonEmail(feku));
			String body = gson.toJson(p);
			HttpResponse<String> response = httpClient.request(URL, body);

			System.out.println("Status: " + response.statusCode());
			System.out.println("Headers: " + response.headers());
			System.out.println("Body: " + response.body());
		}
		
	}

	private static String getRamdonEmail(Faker feku) {
		String firstName = feku.name().firstName();
		String lastName = feku.name().lastName();
		return firstName + "_" + lastName + "@epam.com";
	}
	
	private static Participant getParticipant(Participant p) {
		String eventId = "65451177f7fe277aa9a92531";
		String location = "Colombia";
		p.setEventId(eventId);
		p.setLocation(location);
		p.setRaffleNumber(0);
		return p;
		
	}

}
