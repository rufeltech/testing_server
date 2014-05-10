package ru.eltech.csa.siths.form.entity;

import static org.junit.Assert.*;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.Size;


public class FeaturedAccountTest {
	FeaturedAccount b;

	  public void printType(byte x) {
	        System.out.println(x + " is an byte");
	    }
	    public void printType(int x) {
	   fail("fdafds");
	    }
	    public void printType(float x) {
	        System.out.println(x + " is an float");
	    }
	    public void printType(double x) {
	        System.out.println(x + " is an double");
	    }
	    public void printType(String x) {
	        System.out.println(x + " is an double");
	    }
	    
 @Before
 public void start()
    {
	 FeaturedAccount b = new FeaturedAccount("zxfdsfdsf","test@mail.ru","abcdefgh","abcdefgh");
	}
 
	@Test(expected = Exception.class)
	public void test() {
		
System.out.println(b.name);

	}

	@Test(expected = AnnotationTypeMismatchException.class)
	public void testSetName() {
		FeaturedAccount m = new FeaturedAccount();
		m.setName(123);
		System.out.println(m.name);

	}
	@Test(expected = AnnotationTypeMismatchException.class)
	public void testSetName_2() {
		FeaturedAccount m = new FeaturedAccount();
		m.setName("testing");
		System.out.println(m.name);

	}
	@Test(expected = AnnotationTypeMismatchException.class)
	public void testSetName_3() {
		FeaturedAccount m = new FeaturedAccount();
		m.setName("vc");
		System.out.println(m.name);

	}
	@Test(expected = Exception.class)
	public void testSetName_4() {
		FeaturedAccount m = new FeaturedAccount();
		m.setName("vc");
		System.out.println(m.name);

	}

	@Test(expected = Exception.class)
	public void testGetName() {
		System.out.println(b.getName());

		
	}

	@Test(expected = Exception.class)
	public void testSetEmail() {
		FeaturedAccount b = new FeaturedAccount();
		
		b.setEmail("sdfsdf@mail.ru");
	}
	
	@Test(expected = Exception.class)
	public void testGetEmail() {
		FeaturedAccount b = new FeaturedAccount();
		
		System.out.println(b.getEmail());
	


	}

	@Test
	public void testSetPassword() {
		FeaturedAccount b = new FeaturedAccount();
		b.setPassword("example_password");
	}

	@Test(expected = Exception.class)
	public void testSetPassword_1() {
		FeaturedAccount b = new FeaturedAccount();
		b.setPassword("example_password");
	}
	@Test
	public void testGetPassword() {
		FeaturedAccount b = new FeaturedAccount();
		b.getPassword();
	}
	@Test(expected = Exception.class)
	public void testGetPassword_1() {
		FeaturedAccount b = new FeaturedAccount();
		b.getPassword();
	}

	@Test
	public void testSetPasswordConfirmation() {
		FeaturedAccount b = new FeaturedAccount();
		b.setPasswordConfirmation("confirm_password");
	}

	@Test(expected = Exception.class)
	public void testGetPasswordConfirmation_1() {
		FeaturedAccount b = new FeaturedAccount();
		b.getPasswordConfirmation();
	}


}
