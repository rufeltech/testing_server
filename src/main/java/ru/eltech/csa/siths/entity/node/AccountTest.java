package ru.eltech.csa.siths.entity.node;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test(expected = Exception.class)
	public void testAccountFeaturedAccount() {
		Account rt = new Account("t", "example@mail.ru", "dsd21");
	}

	@Test
	public void testAccountStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSalt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSalt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPasswordHash() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPasswordHash() {
		fail("Not yet implemented");
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
