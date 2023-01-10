package com.helsinkicitybike.HelsinkiCityBikeBackend.journey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin //tämä korjaa react sovelluksessa näkyvän virheilmoituksen 
//access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller	
public class JourneyController {
	@Autowired
	
	private JourneyRepository journeyRepository;
	
	
//1.  ----------LISTAA KAIKKI MATKAT REST-------------------------------------------	
	@GetMapping(path="/api/journeys")
	public @ResponseBody Iterable<Journey> getAllJourneys() {
		// This returns a JSON or XML with the users
		return journeyRepository.findAll();
	}
}