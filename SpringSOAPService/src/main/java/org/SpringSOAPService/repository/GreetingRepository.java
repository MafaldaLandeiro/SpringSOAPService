package org.SpringSOAPService.repository;

import java.util.Date;

import org.example.greetings.Greeting;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class GreetingRepository {

	private static final String templateGreeting = "Hello, %s!";

	public Greeting findCountry(String name) {
		Assert.notNull(name);

		Greeting result = null;

		Date d = new Date();

		String content = String.format(templateGreeting, name);

		result = new Greeting();
		result.setContent(content);
		result.setDate(d.toString());

		return result;
	}
}
