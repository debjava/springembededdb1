package com.ddlab.rnd.spring.db;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * The Class PersonDAOImpl.
 *
 * @author Debadatta Mishra (Piku)
 */
public class PersonDAOImpl implements PersonDAO {

	/** The data source. */
	private DataSource dataSource;
	
	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.db.PersonDAO#getAllPersons()
	 */
	public List<Person> getAllPersons() {
		String sqlQuery = "select * from Person";
		List<Person> persons = jdbcTemplate.query(sqlQuery, new PersonMapper());
		return persons;
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.db.PersonDAO#getPersonById(int)
	 */
	public Person getPersonById(int id) {
		String sqlQuery = "select * from Person where id = ?";
		Person person = jdbcTemplate.queryForObject(sqlQuery,
				new Object[] { id }, new PersonMapper());
		return person;
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.db.PersonDAO#createPerson(com.ddlab.rnd.spring.db.Person)
	 */
	public void createPerson(Person person) {

		String sqlQuery = "insert into Person values (?,?)";
		jdbcTemplate.update(sqlQuery,
				new Object[] { person.getId(), person.getName() });
	}

	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * Sets the data source.
	 *
	 * @param dataSource the new data source
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

}
