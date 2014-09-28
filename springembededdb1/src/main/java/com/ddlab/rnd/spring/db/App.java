package com.ddlab.rnd.spring.db;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * The Class App.
 *
 * @author Debadatta Mishra (Piku)
 */
public class App {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("appBeans.xml");
		PersonDAO personDao = (PersonDAO) context.getBean("personDao");
		for( int i = 1 ; i < 6 ; i++ ) {
			Person person = new Person();
			person.setId(i);
			person.setName("Deb"+i);
			personDao.createPerson(person);
		}
		
		//Get all persons from DB
		List<Person> personList = personDao.getAllPersons();
		for( Person person : personList ) {
			System.out.println("Person Id:::"+person.getId());
			System.out.println("Person Name :::"+person.getName());
		}
		
		//Get person by Id
		Person personById = personDao.getPersonById(3);
		System.out.println("Person Id:::"+personById.getId());
		System.out.println("Person Name :::"+personById.getName());
	}
}
