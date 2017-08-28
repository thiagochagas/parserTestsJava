package br.com.confidence.objecttoxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Test {
	
	public Test() {
		this.classes = new Classes();
	}

	@XmlElement(name = "classes")
	public Classes classes;
	
	@XmlAttribute(name = "name")
	public String name = "all";
	
	@XmlAttribute(name = "preserve-order")
	public String preserve = "false";

}
