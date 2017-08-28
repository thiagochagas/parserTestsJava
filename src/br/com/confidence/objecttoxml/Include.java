package br.com.confidence.objecttoxml;

import javax.xml.bind.annotation.XmlAttribute;

public class Include {
	
	@XmlAttribute(name = "name")
	public String name;
	
	public Include() {
		super();
	}

	public Include(String metodo) {
		this.name = metodo;
	}

}
