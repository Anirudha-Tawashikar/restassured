package stepdefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class hooks {
	
	@Before("@Deleteplace")
	public void beforescenarios() throws IOException {
		
		deifination1 m = new deifination1();
		
//		if(deifination1.place_id==null) {
		
		m.add_place_payload("ajhjhj", "english", " world cross center");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("ajhjhj", "getplaceAPI");
		
		
		
		}
	}

