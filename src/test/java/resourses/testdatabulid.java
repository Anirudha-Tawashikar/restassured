package resourses;

import java.util.ArrayList;
import java.util.List;

import demo.Addplace;
import demo.Location;

public class testdatabulid {
	
	public Addplace addplacepayload(String name ,String language, String adderss) {
		
		 Addplace p= new Addplace();
		   p.setAccuracy(50);
		   p.setAddress(adderss);
		   p.setLanguage(language);
		   p.setPhonenumber("(+91) 983 893 3937");
		   p.setWebsite("http://rahulshettyacademy.com");
		   p.setName(name);
		   List<String> MyList = new ArrayList<String>();
		   MyList.add("shoe park");
		   MyList.add("shop");
		   p.setTypes(MyList);
		   
		   
		   //new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123");
		   
		   Location l= new Location();
		   p.setLocation(l);
		   l.setLat(-38.383494);
		   l.setLng(33.427362);
		   return p;
		
	}
	
	public String deleteplacepayload(String placeId)
	{
		return"{\\r\\n\\\"place_id\\\":\\\""+placeId+"\\\"\\r\\n}";
		
	}

}
