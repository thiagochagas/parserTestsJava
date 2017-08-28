package br.com.confidence.objecttoxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "suite")
public class Suite {
	@XmlAttribute(name = "name")
	public String name = "principal";

	public Suite() {
		this.test = new Test();
	}

	@XmlElement(name = "test")
	public Test test;

}
