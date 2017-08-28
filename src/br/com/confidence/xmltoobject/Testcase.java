package br.com.confidence.xmltoobject;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Testcase {
	
	@XmlAttribute(name = "classname")
	public String classname;
	
	@XmlAttribute(name = "name")
	public String name;
	
	@XmlElement(name = "failure")
	public Failure failure;

	@XmlElement(name = "error")
	public Error error;

	public boolean possuiErro(){
		return this.failure != null || this.error != null;
	}

	
}
