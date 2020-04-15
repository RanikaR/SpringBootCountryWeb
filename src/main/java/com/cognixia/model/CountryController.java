package com.cognixia.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
	
	private static List<CountryWeb> countriesList = new ArrayList<CountryWeb>();
	
	static {
	CountryWeb egypt = new CountryWeb();
	egypt.setName("Egypt");
	egypt.setCapital("Cairo");
	egypt.setPop(68470000);
	
	CountryWeb guam = new CountryWeb();
	guam.setName("Guam");
	guam.setCapital("Hagatna");
	guam.setPop(168000);
	
	CountryWeb morocco = new CountryWeb();
	morocco.setName("Morocco");
	morocco.setCapital("Rabat");
	morocco.setPop(28351000);
	
	CountryWeb philippines = new CountryWeb();
	philippines.setName("Philippines");
	philippines.setCapital("Manila");
	philippines.setPop(104900000);
	
	CountryWeb sweden = new CountryWeb();
	sweden.setName("Sweden");
	sweden.setCapital("Stockholm");
	sweden.setPop(8861400);
	
	countriesList.addAll(Arrays.asList(egypt, guam, morocco, philippines, sweden));
	}
	
	@GetMapping("/countries")
	public String welcome() {
		return "<html><head><title></title></head>"
				+ "<body>"
				+ "<h2>Welcome!</h2>"
				+ "<a>Click here for a list of countries.</a>"
				+ "<br><button onclick=\"location.href = 'http://localhost:8080/countries/list';\" id=\"myButton\" class=\"float-left submit-button\" >Countries List</button>"
				+ "<br><h4>Click to find out a country's population.</h4>"
				+ "<button onclick=\"location.href = 'http://localhost:8080/countries/pop/egypt';\" id=\"myButton\" class=\"float-left submit-button\" >Egypt</button>"
				+ "<br><br><button onclick=\"location.href = 'http://localhost:8080/countries/pop/guam';\" id=\"myButton\" class=\"float-left submit-button\" >Guam</button>"
				+ "<br><br><button onclick=\"location.href = 'http://localhost:8080/countries/pop/morocco';\" id=\"myButton\" class=\"float-left submit-button\" >Morocco</button>"
				+ "<br><br><button onclick=\"location.href = 'http://localhost:8080/countries/pop/philippines';\" id=\"myButton\" class=\"float-left submit-button\" >Philippines</button>"
				+ "<br><br><button onclick=\"location.href = 'http://localhost:8080/countries/pop/sweden';\" id=\"myButton\" class=\"float-left submit-button\" >Sweden</button>"
				+ "</body></html>";
		
	}

	@GetMapping("/countries/list") 
		public List<CountryWeb> displayAll() {
		System.out.println("Countries List \n");
		return countriesList;
	}
	
	
	// use switch-case to switch between name of countries 
	// and display the respective population
	@GetMapping("/countries/pop/{name}") 
		public String getPopulation(@PathVariable String name) {
		
		int i = 0;
		
		switch (name) {
		case "egypt":
			i = 0;
			break;
		case "guam":
			i = 1;
			break;
		case "morocco":
			i = 2;
			break;
		case "philippines":
			i = 3;
			break;
		case "sweden": 
			i = 4;
			break;
		}
		return "The population of " + name.toUpperCase() + " is " + countriesList.get(i).getPop() + " people."
				+ "<html><head></head><body>"
				+ "<br><br><button onclick=\"location.href = 'http://localhost:8080/countries/list';\" id=\"myButton\" class=\"float-left submit-button\" >Return to Countries List</button>"
				+ "<br><br><button onclick=\"location.href = 'http://localhost:8080/countries';\" id=\"myButton\" class=\"float-left submit-button\" >Return to Homepage</button>"
				+ "</body></html>";
	}
	
//	private static final String countryTemplate = "%s";
//	
//	CountryWeb egypt = new CountryWeb();
//	
//	@GetMapping("/{name}")
//	public CountryWeb getEgypt(@PathVariable String name) {
//		egypt.setName(String.format(countryTemplate, name));
//		egypt.setCapital("Cairo");
//		egypt.setPop(16700000);
//		return egypt;
//	}
	

}
