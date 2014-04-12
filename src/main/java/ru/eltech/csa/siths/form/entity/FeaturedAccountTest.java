package ru.eltech.csa.siths.form.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class FeaturedAccountTest {



	@Test(expected = Exception.class)
	public void test() {
		FeaturedAccount b = new FeaturedAccount("dsf","ads@mail.ru","abcdefgh","abcdefgh");
System.out.println(b.name);
	}

	@Test(expected = Exception.class)
	public void testSetName() {
		FeaturedAccount b = new FeaturedAccount();
		b.setName("Nick");
		System.out.println(b.name);
	}

	@Test(expected = Exception.class)
	public void testGetName() {
		FeaturedAccount b = new FeaturedAccount();
		System.out.println(b.getName());
	}

	@Test(expected = Exception.class)
	public void testSetEmail() {
		FeaturedAccount b = new FeaturedAccount();
		b.setEmail("Nick");
	
	}

	@Test
	public void testGetEmail() {
		FeaturedAccount b = new FeaturedAccount();
		System.out.println(b.getEmail());
	}

	@Test
	public void testSetPassword() {
		FeaturedAccount b = new FeaturedAccount();
		b.setPassword("example_password");
	}

	@Test
	public void testGetPassword() {
		FeaturedAccount b = new FeaturedAccount();
		b.getPassword();
	}

	@Test
	public void testSetPasswordConfirmation() {
		FeaturedAccount b = new FeaturedAccount();
		b.setPasswordConfirmation("confirm_password");
	}

	@Test
	public void testGetPasswordConfirmation() {
		FeaturedAccount b = new FeaturedAccount();
		b.getPasswordConfirmation();
	}

}
