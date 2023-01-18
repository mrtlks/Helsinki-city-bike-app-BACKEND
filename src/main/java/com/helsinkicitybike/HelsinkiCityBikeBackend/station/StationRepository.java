package com.helsinkicitybike.HelsinkiCityBikeBackend.station;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Integer> {

// FindBy + Order By + "variable" + desc/asc
// käytetään fid -muuttujaa tässä ensin, koska ei tunnista station_id -muuttujaa alaviivan takia	
	
	   List<Station> findByOrderByFidDesc();
}
