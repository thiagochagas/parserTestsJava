package br.com.confidence.xmltoobject;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Testsuite {

	@XmlElement(name = "testcase")
	public List<Testcase> testcases;
	
	@XmlAttribute(name = "package")
	public String pacote;
	
	@XmlAttribute(name = "name")
	public String name;
	
	@XmlAttribute(name = "failures")
	public Integer falhou;

	@XmlAttribute(name = "errors")
	public Integer errors;


	public boolean falhou() {
		return falhou != 0 || errors != 0;
	}

}
