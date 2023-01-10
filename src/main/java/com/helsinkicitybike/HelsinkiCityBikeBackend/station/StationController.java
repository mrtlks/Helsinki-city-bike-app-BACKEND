package com.helsinkicitybike.HelsinkiCityBikeBackend.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
//korjaa ongelman access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller
public class StationController {

	@Autowired

	private StationRepository stationRepository;

// 1.  ----------LISTAA KAIKKI ASEMAT  REST -------------------------------------------	
	@GetMapping(path = "/api/stations")
	public @ResponseBody Iterable<Station> getAllStations() {
		return stationRepository.findAll();
	}

}
