package bootathon1;

import java.util.*;
public class AddVehicle {
	static Set<String> vehicleList=new HashSet<>();
	static Set<String> licenseList=new HashSet<>();
	public AddVehicle(String vehicle) {
		vehicleList.add(vehicle);
		System.out.println(vehicleList);
	}
	public AddVehicle(String license,int n) {
		licenseList.add(license);
		System.out.println(licenseList);
	}
}
