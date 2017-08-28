package br.com.confidence.objecttoxml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Classes {

	@XmlElement(name = "class")
	public List<Classe> classe;

}
