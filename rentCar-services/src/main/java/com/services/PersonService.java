package com.services;

import java.util.List;

import com.models.Person;

public interface PersonService {

	List<Person> getAllPersons();
	
	Person savePerson(Person person);
	
	Person getById(Long id);
	
	void deleteById(Long id);
	
	Person getByName(String name);
	
	String getNameById(Long id);
	
	void updateById(String name, Long id);
}

