package com.rocha.app.httptest;

import java.io.IOException;

import com.rocha.app.participant.service.ParticipantService;

public class HttpTestPost {

	public static void main(String[] args) throws IOException, InterruptedException {

		String URL = "http://ecsa0040129d.epam.com:8084/api/participant/v1/raffle-tool/participation";
		ParticipantService.registerParticipant(1, URL);

	}

	

}
