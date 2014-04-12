package ru.eltech.csa.siths.entity.node;

import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractTextPostTest {

	@Test(expected = Exception.class)
	public void testAbstractTextPostString() {
		AbstractTextPost p = new AbstractTextPost("test");
	}


	@Test(expected = Exception.class)
	public void testSetText() {
		AbstractTextPost p = new AbstractTextPost();
		p.setText("text");
	}

	@Test
	public void testGetText() {
		AbstractTextPost p = new AbstractTextPost();
		p.getText();
	}

	@Test
	public void testSetPost() {
		AbstractTextPost p = new AbstractTextPost();
		p.setPost("03030");
	}

	@Test
	public void testGetPost() {
		AbstractTextPost p = new AbstractTextPost();
		p.getPost();
	}

}
