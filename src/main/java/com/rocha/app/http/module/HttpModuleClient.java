package com.rocha.app.http.module;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class HttpModuleClient {

	public HttpResponse<String> request(final String URL, final String body) throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).timeout(Duration.ofSeconds(2))
				.header("Content-Type", "application/json").POST(BodyPublishers.ofString(body)).build();

		HttpClient client = HttpClient.newHttpClient();

		return client.send(request, BodyHandlers.ofString());
	}

}
