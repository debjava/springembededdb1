package com.ddlab.rnd.spring.db;

import java.util.List;

/**
 * The Interface PersonDAO.
 *
 * @author Debadatta Mishra (Piku)
 */
public interface PersonDAO {
	
	/**
	 * Gets the all persons.
	 *
	 * @return the all persons
	 */
	public List<Person> getAllPersons();

	/**
	 * Gets the person by id.
	 *
	 * @param id the id
	 * @return the person by id
	 */
	public Person getPersonById(int id);

	/**
	 * Creates the person.
	 *
	 * @param person the person
	 */
	public void createPerson(Person person);
}