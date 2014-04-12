package ru.eltech.csa.siths.entity.node;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {

	@Test(expected = Exception.class)
	public void testAddressStringStringStringStringStringString() {
	
		  Address test = new Address( "test", 
                  "test", 
                 "test", 
                  "t",
                  "test",
                  "test" );
	}

	@Test
	public void testAddressStringStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCountryName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCountryName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStateOrProvinceName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStateOrProvinceName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCityName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCityName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPostalCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPostalCode() {
		fail("Not yet implemented");
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
