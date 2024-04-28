package com.springlearn.springframework.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Service;

//@Component
@Service//this annotation is used to define classes where there is business logic
//@component would work too, but @service makes code more understandable
public class BusinessCalculationService {
	DataService dataService;
	
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findmax() {
		return Arrays.stream(dataService.retriveData()).max().orElse(0);
	}
}
