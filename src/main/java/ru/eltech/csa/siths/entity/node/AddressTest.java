package ru.eltech.csa.siths.entity.node;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test(expected = Exception.class)
	public void testAddressStringStringStringStringStringString() {
	
		  Address test = new Address( "test", "test", "test", "t", "test","test" );
	}




	@Test(expected = Exception.class)
	public void testSetCountryName() {
		 Address test = new Address();
		 test.setCountryName("A");
	}

	@Test
	public void testGetCountryName() {
		 Address test = new Address();
		 test.getCountryName();
	}

	@Test
	public void testSetStateOrProvinceName() {
		 Address test = new Address();
		 test.setStateOrProvinceName();
	}

	@Test
	public void testGetStateOrProvinceName() {
		 Address test = new Address();
		 test.getStateOrProvinceName();
	}

	@Test
	public void testSetCityName() {
		 Address test = new Address();
		 test.SetCityName("Los_Angeles");
	}

	@Test
	public void testGetCityName() {
		 Address test = new Address();
		 test.getCityName("Los_Angeles");
	}

	@Test
	public void testSetPostalCode() {
		 Address test = new Address();
		 test.setPostalCode("Los_Angeles");
	}

	@Test
	public void testGetPostalCode() {
		 Address test = new Address();
		 test.getPostalCode("Los_Angeles");
	}

	@Test
	public void testSetPrimaryAddressLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrimaryAddressLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSecondaryAddressLine() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSecondaryAddressLine() {
		fail("Not yet implemented");
	}

}
