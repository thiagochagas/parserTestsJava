package br.com.confidence.xmltoobject;

import javax.xml.bind.annotation.XmlAttribute;

public class Error {

	@XmlAttribute(name = "message")
	public String mensagem;

}
