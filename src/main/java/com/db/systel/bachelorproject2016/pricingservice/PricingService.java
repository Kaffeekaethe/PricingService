package com.db.systel.bachelorproject2016.pricingservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PricingService {	
	
	public static void main(String args[]){
		
		new SpringApplicationBuilder(PricingService.class).web(true).run(args);
	}
	

}
