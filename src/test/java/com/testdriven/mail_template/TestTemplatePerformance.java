package com.testdriven.mail_template;

import junit.framework.TestCase;

public class TestTemplatePerformance extends TestCase {

	private Template template;

	public void setUp() throws Exception {
		template = new Template(
				"${one}, ${two}, ${three}  asdf  afasdf afasdf  afdf a  af afd a f fd a fa  af  afdfa this is a hundred word template probably");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}

	public void testTemplateWith100WordsAnd20Variables() throws Exception {
		long expected = 200L;
		long time = System.currentTimeMillis();
		template.evaluate();
		time = System.currentTimeMillis() - time;
		assertTrue("Rendering the template took " + time
				+ "ms while the target was " + expected + "ms",
				time <= expected);
	}
}
