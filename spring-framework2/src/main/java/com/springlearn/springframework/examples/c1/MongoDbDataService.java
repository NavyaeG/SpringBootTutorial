package com.springlearn.springframework.examples.c1;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Component
@Repository//indicates that annotated class is a repository, typically any interaction with database is done by these classes
//Component would work here as well, but @Repository makes the code more understandable
@Primary
public class MongoDbDataService implements DataService{

	public int[] retriveData() {
		return new int[] {11,22,33,44,55};
	}
}