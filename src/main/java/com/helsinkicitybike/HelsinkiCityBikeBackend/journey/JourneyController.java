package com.helsinkicitybike.HelsinkiCityBikeBackend.journey;

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
public class JourneyController {
	@Autowired
	
	private JourneyRepository journeyRepository;
	
	
//1.  ----------LISTAA KAIKKI MATKAT REST-------------------------------------------	
	@GetMapping(path="/api/journeys")
	public @ResponseBody Iterable<Journey> getAllJourneys() {
		// This returns a JSON or XML with the users
		return journeyRepository.findAll();
	}
	
	
	
	// THYMELEAF --------------------------------------------------------------------------	

	//1. ASEMIEN LISTAUS-----------------	
		@RequestMapping(value = "/journeys")
		public String stationsList(Model model) {
			// haetaan asemat fid-järjestyksessä suurimmasta pienimpään (jotta uusimmat
			// näkyvät ensin)
			model.addAttribute("journeys", journeyRepository.findByOrderByIdDesc());
			model.addAttribute("journey", new Journey()); // "tyhjä" olio
			return "journeyspage";
		}

	// 2. ASEMAN TALLENTAMINEN		
		@RequestMapping(value = "/savejourney", method = RequestMethod.POST)
		public String saveJourney(Journey journey) {
			
			journeyRepository.save(journey);
			
			//tämä on linkki, ei thymeleaf
			return "redirect:journeys";
		}

	// 3. ASEMAN POISTAMINEN--------------------------------------------------------------------	
//					@RequestMapping(value = "delete/station/{id}", method = RequestMethod.GET)
//					public String deleteStation(@PathVariable("id") int station_id) {
//						stationRepository.delete(stationRepository.findById(station_id).get());				
//						return "redirect:/stations";
//					}

	//3. ASEMAN POISTAMINEN Jos matka on "removable"--------------------------------------------------------------------	
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
	}