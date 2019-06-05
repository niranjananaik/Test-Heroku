/**
 * 
 */
package com.test.testProject.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.testProject.model.ClientIDTest;



/**
 * @author niranjana_naik
 *
 */
@RestController
public class AppController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Hello World!";
	}
	
	@RequestMapping(value = "/webhook", method = RequestMethod.GET)
	public ClientIDTest getWebhookGET(@RequestHeader("X-AdobeSign-ClientId") String xAdobeSignClientId) {
		// ClientId getWebhookGET() {
		ClientIDTest clientId = new ClientIDTest();
		// clientId.setxAdobeSignClientId("CBJCHBCAABAAVAMhAcHcH-oyVVAzsdm8qelsEg2N__ZA");
		clientId.setxAdobeSignClientId(xAdobeSignClientId);
		System.out.println("GET Mehtod:" + clientId.getxAdobeSignClientId());
		return clientId;
	}

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	public ClientIDTest getWebhookPostEvent(@RequestHeader("X-AdobeSign-ClientId") String xAdobeSignClientId,
			@RequestBody Object object) throws IOException {
		System.out.println("POST method " + xAdobeSignClientId);
		System.out.println("output:" + object);
		return (ClientIDTest) object;
	}
}
