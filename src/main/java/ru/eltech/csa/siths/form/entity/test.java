package ru.eltech.csa.siths.form.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test(expected = Exception.class)
	public void test() {
		FeaturedAccount b = new FeaturedAccount("ds","ads@mail.ru","abcdefgh","abcdefgh");
System.out.println(b.name);
	}

}
