/**
 * 
 */
package com.test.testProject.controller;

import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.testProject.model.ClientIDTest;



/**
 * @author niranjana_naik
 *
 */
@RestController
public class AppController {
	private Logger logger = Logger.getLogger(this.getClass());
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		logger.info("/test");
		return "Hello World!";
	}
	
	@RequestMapping(value = "webhook", method = RequestMethod.GET)
	public ClientIDTest getWebhookGET(@RequestHeader("X-AdobeSign-ClientId") String xAdobeSignClientId) {
		// ClientId getWebhookGET() {
		ClientIDTest clientId = new ClientIDTest();
		// clientId.setxAdobeSignClientId("CBJCHBCAABAAVAMhAcHcH-oyVVAzsdm8qelsEg2N__ZA");
		clientId.setxAdobeSignClientId(xAdobeSignClientId);
		System.out.println("GET Mehtod:" + clientId.getxAdobeSignClientId());
		logger.info("test");
		return clientId;
	}

	@RequestMapping(value = "webhook", method = RequestMethod.POST)
	public Object getWebhookPostEvent(@RequestHeader("X-AdobeSign-ClientId") String xAdobeSignClientId,
			@RequestBody Object object) throws IOException {
		System.out.println("POST method " + xAdobeSignClientId);
		System.out.println("output:" + object);
		logger.info("test");
		logger.info(object);
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestHeaders.add("X-AdobeSign-ClientId", "CBJCHBCAABAA3YbwhlndQsqFqIo3cNG08LHSvOoI1Cjr");
		
		HttpEntity<String> requestEntity = new HttpEntity<>(object.toString(), requestHeaders);
		RestTemplate template = new RestTemplate();
		template.exchange("http://10.222.73.26:8888/inperson/test", HttpMethod.GET, requestEntity, String.class);
		logger.info("object-->" + object);
		return object;
	}
}
