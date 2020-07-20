package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name,String language,String address) {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		Location l = new Location();
		l.setLat(12);
		l.setLng(15);
		p.setLocation(l);
		p.setName(name);
		p.setPhone_number("(01) 561 758 0497");
		List<String> types = new ArrayList<String>();
		types.add("Shoe park");
		types.add("Shop");
		p.setTypes(types);
		return p;
	}
	
	public String deletePayload(String place_id) {
		
		return "{\r\n" + 
				"    \"place_id\":\""+place_id+"\"\r\n" + 
				"}\r\n" + 
				"";

	}

}
