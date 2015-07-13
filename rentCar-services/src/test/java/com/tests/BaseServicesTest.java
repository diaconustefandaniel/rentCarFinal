package com.tests;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.services.PersonService;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/rentCar-services-config-test.xml")
@Transactional
public abstract class BaseServicesTest {

	@Autowired
	protected PersonService personService;
	
	
}
