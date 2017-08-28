package br.com.confidence.objecttoxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Classe {

	@XmlAttribute(name = "name")
	public String name;
	
	@XmlElement(name="methods")
	public Methods methods;

	public Classe() {
		super();
	}
	
	public Classe(String classe) {
		this.name = classe;
	}
}
