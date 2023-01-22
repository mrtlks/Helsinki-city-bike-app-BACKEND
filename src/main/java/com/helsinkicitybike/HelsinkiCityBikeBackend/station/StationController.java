package com.helsinkicitybike.HelsinkiCityBikeBackend.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
//tämä korjaa react sovelluksessa näkyvän virheilmoituksen 
//access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller
public class StationController {

	@Autowired
	private StationRepository stationRepository;

// REST -----------------------------------------------------------------------------

// 1. ASEMIEN LISTAUS -----------------	

	@GetMapping(path = "/api/stations")
	public @ResponseBody Iterable<Station> getAllStations() {
		return stationRepository.findAll();
	}

// THYMELEAF --------------------------------------------------------------------------	

//1. ASEMIEN LISTAUS-----------------	

	@RequestMapping(value = "/stations")
	public String stationsList(Model model) {
		// haetaan asemat fid-järjestyksessä suurimmasta pienimpään (jotta uusimmat
		// näkyvät ensin)
		model.addAttribute("stations", stationRepository.findByOrderByFidDesc());
		model.addAttribute("station", new Station()); // "tyhjä" olio
		return "stationspage";
	}

// 2.  ASEMAN TALLENTAMINEN -----------------

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStation(Station station) {

		// tässä kaikki tiedot joita käyttäjä ei ole antanut
		station.setNimi(station.getName());
		station.setNamn(station.getName());
		station.setAdress(station.getStation_address());
		station.setStad(station.getStation_city());
		station.setIsremovable(true);
		station.setEditable(false);
		stationRepository.save(station);

		// tämä on linkki, ei thymeleaf
		return "redirect:stations";
	}

//3. ASEMAN POISTAMINEN Jos asema on "removable"--------------------------------------------------------------------	
	@RequestMapping(value = "delete/station/{id}", method = RequestMethod.GET)
	public String deleteStationifremovable(@PathVariable("id") int station_id) {
		Station station = stationRepository.findById(station_id).get();
		if (station.getIsremovable()) {
			stationRepository.delete(stationRepository.findById(station_id).get());
		} else {
			System.out.print("not removable");
		}
		return "redirect:/stations";
	}

	/*
	 * 4. ASEMAN MUOKKAAMINEN
	 * 
	 * @RequestMapping(value = "/edit/{id}/station", method = RequestMethod.GET)
	 * public String editStation(@PathVariable("id") int station_id, Model model) {
	 * Optional<Station> station = stationRepository.findById(station_id);
	 * model.addAttribute("station", station); return "editstation"; }
	 */

// 4.ASEMAN MUOKKAAMINEN, jos asema on editable  ----------------------------

	@RequestMapping(value = "/edit/{id}/station", method = RequestMethod.GET)
	public String editStationifEditable(@PathVariable("id") int id, Model model) {

		Station station = stationRepository.findById(id).get();
		System.out.print("-------- aseman id" + id);
		if (station.getEditable()) {
			model.addAttribute("station", station);
		} else {
			System.out.print("not editable");
			return "redirect:/stations";
		}
		return "editstation";
	}
}
