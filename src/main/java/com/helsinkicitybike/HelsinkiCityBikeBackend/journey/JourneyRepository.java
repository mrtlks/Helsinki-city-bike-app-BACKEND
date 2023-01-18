package com.helsinkicitybike.HelsinkiCityBikeBackend.journey;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface JourneyRepository  extends CrudRepository<Journey, Integer>{

	   List<Journey> findByOrderByIdDesc();
}
