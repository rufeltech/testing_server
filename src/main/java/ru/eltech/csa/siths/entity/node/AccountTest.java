package ru.eltech.csa.siths.entity.node;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test(expected = Exception.class)
	public void testAccountFeaturedAccount() {
		Account rt = new Account("t", "example@mail.ru", "dsd21");
	}


	@Test(expected = Exception.class)
	public void testSetName() {
		Account rt = new Account();
		rt.setName("Name");
	}

	@Test(expected = Exception.class)
	public void testGetName() {
		Account rt = new Account();
		rt.getName();
	}

	@Test(expected = Exception.class)
	public void testSetEmail() {
		Account rt = new Account();
		rt.setEmail("example@mail.ru");
	}

	@Test(expected = Exception.class)
	public void testGetEmail() {
		Account rt = new Account();
		rt.getEmail();
	}

	@Test(expected = Exception.class)
	public void testSetSalt() {
		Account rt = new Account();
		rt.setSalt("test");
	}

	@Test(expected = Exception.class)
	public void testGetSalt() {
		Account rt = new Account();
		rt.getSalt();
	}

	@Test(expected = Exception.class)
	public void testSetPasswordHash() {
		Account rt = new Account();
		rt.setPasswordHash("dj4sk5");
	}

	@Test(expected = Exception.class)
	public void testGetPasswordHash() {
		Account rt = new Account();
		rt.getPasswordHash();
	}

	@Test
	public void testAddRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPermissions() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPermissions() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOwnership() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOwnership() {
		fail("Not yet implemented");
	}

}
