package com.rocha.app.httptest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import com.google.gson.Gson;

public class HttpTestGetProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String URL = "http://localhost:8080/products/6";
		Gson gson = new Gson();

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
		
		
		ProductDto userDto = gson.fromJson(response.body(), ProductDto.class);
		
		System.out.println("Product: " + userDto);
		
		
		

	}

}
