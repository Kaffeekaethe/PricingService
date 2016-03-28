package com.db.systel.bachelorproject2016.pricingservice.api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.db.systel.bachelorproject2016.pricingservice.domainmodel.PriceCalculator;
import com.db.systel.bachelorproject2016.pricingservice.domainmodel.Seat;

@Configuration
@EnableAutoConfiguration
@Controller
public class PricingController {

	@RequestMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("I am a pricing service.", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get-price")
	public ResponseEntity<Float> allCustomers(@RequestParam(value = "seatClass") int seatClass,
			@RequestParam(value = "seatArea", required = false, defaultValue = "default") String seatArea,
			@RequestParam(value = "seatLocation", required = false, defaultValue = "default") String seatLocation,
			@RequestParam(value = "seatCompartmentType", required = false, defaultValue = "default") String seatCompartmentType,
			@RequestParam(value = "upperLevel", required = false, defaultValue = "false") boolean upperLevel) {

		System.out.println("Received update to calculate price");
		float price = PriceCalculator
				.calculatePrice(new Seat(seatClass, seatArea, seatLocation, seatCompartmentType, upperLevel));

		return new ResponseEntity<Float>(price, HttpStatus.OK);
	}

}
