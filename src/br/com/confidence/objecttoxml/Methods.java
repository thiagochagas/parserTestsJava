package br.com.confidence.objecttoxml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Methods {
	
	@XmlElement(name = "include")
	public List<Include> include;
	
	public Methods() {
		this.include = new ArrayList<Include>();
	}

	public void addIncludes(List<Include> includes){
		this.include.addAll(includes);
			
	}

}
