package com.helsinkicitybike.HelsinkiCityBikeBackend.station;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface StationRepository extends PagingAndSortingRepository<Station, Integer> {

	List<Station> findByOrderByFidDesc();

	Station findByName(String name);

	Page<Station> findByOrderByName(Pageable pageable);

	Page<Station> findByOrderByNameDesc(Pageable pageable);

	Page<Station> findByOrderById(Pageable pageable);

	Page<Station> findByOrderByFidDesc(Pageable pageable);

	Page<Station> findByOrderByIdDesc(Pageable pageable);

	

}
