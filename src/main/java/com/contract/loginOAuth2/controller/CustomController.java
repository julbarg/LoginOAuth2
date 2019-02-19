package com.contract.loginOAuth2.controller;

import static com.contract.loginOAuth2.constans.ContractMethodsConstans.*;
import static com.contract.loginOAuth2.constans.PrivilegeConstans.*;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.contract.entities.custom.Custom;

@RestController
public class CustomController {
	
	@RequestMapping(value = CUSTOM_FIND_ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Secured(CAN_READ_USERS)
	public List<Custom> findAll(){
		RestTemplate restTemplate = new RestTemplate();
        List<Custom> customsList = restTemplate.getForObject(URL_CONTRACT + CUSTOM_FIND_ALL, List.class);
       return customsList; 
	}
	
	@RequestMapping(value = CUSTOM_INSERT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Custom insert(@RequestBody Custom custom) {
		RestTemplate restTemplate = new RestTemplate();
		custom = restTemplate.postForObject(URL_CONTRACT + CUSTOM_INSERT, custom, Custom.class);
		
		return custom;
	}
	
	

}
