package com.rocha.app.httptest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class HttpTestGet {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String URL = "https://postman-echo.com/get?test=123&rocha=hola&id=b0deeae5-cc26-4aef-9a88-880bf28a50b1&time-stime=1697594184";

		HttpRequest request = HttpRequest.newBuilder().
				uri(URI.create(URL)).
				timeout(Duration.ofSeconds(10)).
				GET()
				.build();
		HttpClient client = HttpClient.newHttpClient();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		System.out.println("Status: " + response.statusCode());
		System.out.println("Headers: " + response.headers());
		System.out.println("Body: " + response.body());
		
		//client.close();

	}

}
