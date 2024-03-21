package resourses;

//enum is special class in java which has collection constatnt of methods 

public enum Apiresourses {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getplaceAPI("/maps/api/place/get/json"),
	deleteplaceAPI("/maps/api/place/delete/json");
	private String resourses;
	
	
	Apiresourses(String resourses)
	
	{
		this.resourses= resourses;
	}
	
	public String getresourses(){
		
		return resourses;
		
		
	}

}
