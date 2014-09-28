package com.ddlab.rnd.spring.db;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class PersonTest.
 *
 * @author Debadatta Mishra (PIKU)
 * Running test cases in order of method names in ascending order
 * Use @FixMethodOrder(MethodSorters.NAME_ASCENDING).
 * But it s always discouraged because all test cases should be independent.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonTest {
	
	/** The context. */
	private static ApplicationContext context = null;
	
	/** The person dao. */
	private static PersonDAO personDao = null;
	
	/**
	 * Inits the.
	 */
	@BeforeClass
	public static void init() {
		new PersonTest().doSetup();
	}
	
	/**
	 * Do setup.
	 */
	public void doSetup() {
		context = new ClassPathXmlApplicationContext("testBeans.xml");
		personDao = (PersonDAO) context.getBean("personDao");
	}
	
	/**
	 * Test create person.
	 */
	@Test
	public void testCreatePerson() {
		createPerson("Deb");
		Person p1 = personDao.getPersonById(1);
		assertEquals(1,p1.getId());
	}
	
	/**
	 * Test get all persons.
	 */
	@Test
	public void testGetAllPersons() {
		List<Person> personList = personDao.getAllPersons();
		if(personList.size() == 0 ) {
			createPerson("Deb");
			personList = personDao.getAllPersons();
		}
		assertEquals(1, personList.size());
	}
	
	@Test
	public void testGetPersonById() {
		createPerson("Deb3");
		Person p1 = personDao.getPersonById(1);
		assertEquals(1,p1.getId());
	}
	
	/** The id. */
	private static int id = 0;
	
	/**
	 * Creates the person.
	 *
	 * @param personName the person name
	 */
	private void createPerson(String personName) {
		Person p1 = new Person();
		p1.setId((++id));
		p1.setName(personName);
		personDao.createPerson(p1);
	}

}
