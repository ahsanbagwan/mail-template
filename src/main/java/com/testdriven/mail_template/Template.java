package com.testdriven.mail_template;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Template {

	private Map<String, String> variables;
	private String templateText;

	public Template(String templateText) {
		// super();
		this.variables = new HashMap<String, String>();
		this.templateText = templateText;

	}

	public void set(String name, String value) {
		this.variables.put(name, value);
	}

	public String evaluate() {
		String result = templateText;
		for (Entry<String, String> entry : variables.entrySet()){
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		return result;
	}
}
