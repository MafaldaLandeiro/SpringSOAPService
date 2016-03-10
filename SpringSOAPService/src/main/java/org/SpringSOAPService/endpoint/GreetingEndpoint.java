package org.SpringSOAPService.endpoint;

import org.SpringSOAPService.repository.GreetingRepository;
import org.example.greetings.GetGreetingRequest;
import org.example.greetings.GetGreetingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GreetingEndpoint {
	private static final String NAMESPACE_URI = "http://www.example.org/greetings";

	private GreetingRepository greetingRepository;

	@Autowired
	public GreetingEndpoint(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGreetingRequest")
	@ResponsePayload
	public GetGreetingResponse getGreeting(
			@RequestPayload GetGreetingRequest request) {
		GetGreetingResponse response = new GetGreetingResponse();
		response.setGreeting(greetingRepository.getGreeting(request.getName()));
		return response;
	}

}
