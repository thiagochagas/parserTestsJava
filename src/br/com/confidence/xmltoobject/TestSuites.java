package br.com.confidence.xmltoobject;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "testsuites")
public class TestSuites {
	
	@XmlElement(name = "testsuite")
	public List<Testsuite> testSuites;


}
