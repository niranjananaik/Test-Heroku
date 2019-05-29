/**
 * 
 */
package com.test.testProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author niranjana_naik
 *
 */
@RestController
public class AppController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test() {
		return "Hello World!";
	}
}
