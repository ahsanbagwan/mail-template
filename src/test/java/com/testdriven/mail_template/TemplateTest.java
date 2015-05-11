package com.testdriven.mail_template;

import junit.framework.TestCase;

public class TemplateTest extends TestCase {
	private Template template;

	public void setUp() throws Exception {
		template = new Template("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}

	public void testMultipleVariables() throws Exception {
		assertTemplateEvaluatesTo("1, 2, 3");
	}

	public void testUnknownVariablesAreIgnored() throws Exception {
		template.set("doesnotexist", "Hi");
		assertTemplateEvaluatesTo("1, 2, 3");
	}

	public void testMissingValuesRaisesException() throws Exception {
		try {
			new Template("${foo}").evaluate();
			fail("evaluate() should throw an exception if a variable was left without a value");

		} catch (MissingValueException expected) {

		}
	}

	private void assertTemplateEvaluatesTo(String expected) {
		assertEquals(expected, template.evaluate());
	}
}
