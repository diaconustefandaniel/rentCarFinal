package com.tests;

import org.junit.Test;

import com.tests.BaseServicesTest;
import com.models.Person;
import junit.framework.Assert;

public class PersonTest extends BaseServicesTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testSave(){
		Person p = new Person();
		p.setName("TTT");
		Person newPErson = this.personService.savePerson(p);
		Person found = this.personService.getById(newPErson.getId());
		Assert.assertEquals("TTT", found.getName());
	}
}