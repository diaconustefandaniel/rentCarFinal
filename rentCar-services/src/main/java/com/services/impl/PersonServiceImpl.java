package com.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.Person;
import com.repository.PersonRepository;
import com.services.PersonService;



@Service
@Transactional
public class PersonServiceImpl implements PersonService{

	@Autowired
    private PersonRepository personRepository;
	
	public List<Person> getAllPersons() {
		return this.personRepository.findAll();
	}

	public Person savePerson(Person person) {
		return this.personRepository.save(person);
	}

	public Person getById(Long id) {
		return this.personRepository.findOne(id);
	}

	public void deleteById(Long id) {
		this.personRepository.delete(id);
		
	}

	public Person getByName(String name) {
		return this.personRepository.getByName(name);
	}

	public String getNameById(Long id) {
		return this.personRepository.getNameById(id);
	}

	public void updateById(String name, Long id) {
		this.personRepository.updateById(name, id);
		
	}

}
