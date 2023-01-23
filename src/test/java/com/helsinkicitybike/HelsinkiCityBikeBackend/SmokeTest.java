package com.helsinkicitybike.HelsinkiCityBikeBackend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.helsinkicitybike.HelsinkiCityBikeBackend.comment.CommentController;
import com.helsinkicitybike.HelsinkiCityBikeBackend.journey.JourneyController;
import com.helsinkicitybike.HelsinkiCityBikeBackend.station.StationController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private StationController stationController;

	@Autowired
	private JourneyController journeyController;
	
	@Autowired
	private CommentController commentController;
	
	
//	  https://spring.io/guides/gs/testing-web/
//1. "simple sanity check test that will fail if the application context cannot start"
	@Test
	public void contextLoads() {
	}

	
	
//  https://spring.io/guides/gs/testing-web/	
// "To convince yourself that the context is creating your controller, you could add an assertion"	
	
// Testataan kaikki Controller-luokat	
	@Test
	public void contextLoads1() throws Exception {
		assertThat(stationController).isNotNull();
	}
	
	@Test
	public void contextLoads2() throws Exception {
		assertThat(journeyController).isNotNull();
	}
	
	@Test
	public void contextLoads3() throws Exception {
		assertThat(commentController).isNotNull();
	}
	
	
}

/*https://spring.io/guides/gs/testing-web/ 

*/