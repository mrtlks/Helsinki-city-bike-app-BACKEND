package com.helsinkicitybike.HelsinkiCityBikeBackend.journey;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helsinkicitybike.HelsinkiCityBikeBackend.station.Station;
import com.helsinkicitybike.HelsinkiCityBikeBackend.station.StationRepository;


@CrossOrigin 
//tämä korjaa react sovelluksessa näkyvän virheilmoituksen 
//access-to-fetch-at-from-origin--has-been-blocked-by-cors

@Controller	
public class JourneyController {
	
	@Autowired	
	private JourneyRepository journeyRepository;
	
	@Autowired
	private StationRepository stationRepository;
	

	

//  REST -------------------------------------------	
	
//1. MATKOJEN LISTAUS -----------------	
	
	@GetMapping(path="/api/journeys")
	public @ResponseBody Iterable<Journey> getAllJourneys() {
		// This returns a JSON or XML with the users
		return journeyRepository.findAll();
	}
	
	
	
// THYMELEAF --------------------------------------------------------------------------	

//1. MATKOJEN LISTAUS -----------------	
	
		@RequestMapping(value = "/journeys")
		public String stationsList(Model model) {
			// haetaan asemat fid-järjestyksessä suurimmasta pienimpään (jotta uusimmat
			// näkyvät ensin)
			model.addAttribute("journeys", journeyRepository.findByOrderByIdDesc());
			model.addAttribute("stations", stationRepository.findAll());
			model.addAttribute("journey", new Journey()); // "tyhjä" olio
		 
			return "journeyspage";
		}

	
		
// 2.MATKAN TALLENTAMINEN -----------------
		
		@RequestMapping(value = "/savejourney", method = RequestMethod.POST)
		public String saveJourney(Journey journey) {
		// matkaan on jo asetettuna jo DepartureStationName sekä ReturnStationName, jotka käyttäjä antanut lomakkeeseen
	    // haetaan siis tämä "journey.departureStationName" muuttujaan "departureStationName"
			String departureStationName = journey.getDepartureStationName();
			String returnStationName = journey.getReturnStationName();
		// nyt muuttujassa on pelkästään string arvo, joka on aseman nimi		
			System.out.print("-------- Lähtöasema: " + departureStationName);
			System.out.print("-------- Paluuasema: " + returnStationName);
        // --> aseman nimen avulla voidaan hakea kyseisen aseman id (station_id) StationRepositorysta
			
			Station dstation = stationRepository.findByName(departureStationName);
			Station rstation = stationRepository.findByName(returnStationName);
			
			int dstationid = dstation.getStation_id();
			int rstationid = rstation.getStation_id();
			//Journey journey = journeyRepository.findById(id).get();
			journey.setDepartureStationId(dstationid);
			journey.setReturnStationId(rstationid);
	    //		Station station = journeyRepository.findByStationName(departureStationName).get();	
			journey.setRemovable(true);		
			
			journeyRepository.save(journey);
			
			//tämä on linkki, ei thymeleaf
			return "redirect:journeys";
		}
			
	

//3.  MATKAN POISTAMINEN jos matka on "removable"--------------------------------------------------------------------	
		@RequestMapping(value = "delete/journey/{id}", method = RequestMethod.GET)
		public String deleteJourneyifremovable(@PathVariable("id") int id) {
			Journey journey = journeyRepository.findById(id).get();
			if (journey.getRemovable()) {
				journeyRepository.delete(journeyRepository.findById(id).get());
			} else {
				System.out.print("not removable");
			}
			return "redirect:/journeys";
		} 
		
		
// 4. MATKAN MUOKKAAMINEN ----------------------------
	    
	    @RequestMapping(value = "/edit/{id}/journey", method =RequestMethod.GET)
	      public String editJourney(@PathVariable("id") int id, Model model){
	    	Optional<Journey> journey = journeyRepository.findById(id); 	
	  		 model.addAttribute("journey", journey);	  
	          return "editjourney";
	   }		
		
	}



