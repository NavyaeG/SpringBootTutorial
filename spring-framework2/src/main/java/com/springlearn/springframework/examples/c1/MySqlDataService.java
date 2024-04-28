package com.springlearn.springframework.examples.c1;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository//indicates that annotated class is a repository, typically any interaction with database is done by these classes
//Component would work here as well, but @Repository makes the code more understandable
public class MySqlDataService implements DataService{

	public int[] retriveData() {
		return new int[] {1,2,3,4,5};
	}
}