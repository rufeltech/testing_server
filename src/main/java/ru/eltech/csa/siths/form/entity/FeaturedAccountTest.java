package ru.eltech.csa.siths.form.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class FeaturedAccountTest {

	@Test
	public void testFeaturedAccountStringStringStringString() {
		fail("Not yet implemented");
	}

	@Test(expected = Exception.class)
	public void test() {
		FeaturedAccount b = new FeaturedAccount("dsf","ads@mail.ru","abcdefgh","abcdefgh");
System.out.println(b.name);
	}

	@Test(expected = Exception.class)
	public void testSetName() {
		FeaturedAccount b = new FeaturedAccount();
		b.name="da";
		System.out.println(b.name);
	}

	@Test(expected = Exception.class)
	public void testGetName() {
		FeaturedAccount b = new FeaturedAccount();
		System.out.println(b.getName());
	}

	@Test(expected = Exception.class)
	public void testSetEmail() {
		FeaturedAccount b = new FeaturedAccount("dsf","ads@mail.ru","abcdefgh","abcdefgh");
		System.out.println(b.getName());
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPasswordConfirmation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPasswordConfirmation() {
		fail("Not yet implemented");
	}

}
