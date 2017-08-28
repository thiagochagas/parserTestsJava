package br.com.confidence.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URLDecoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLUtil {

	private static final String UTF_8 = "UTF-8";

	public static String objectToXML(Object obj) {
		try {
			JAXBContext jc = JAXBContext.newInstance(obj.getClass());
			Marshaller conversor = jc.createMarshaller();
			StringWriter writer = new StringWriter();
			conversor.marshal(obj, writer);
			return URLDecoder.decode(writer.toString(), UTF_8);

		} catch (Exception e) {
			throw new RuntimeException("Erro ao converter o xml em objeto." + obj, e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends Object> T xmlToObject(String xml, Class<T> obj) {

		String xmlDecoded = null;
		try {
			xmlDecoded = URLDecoder.decode(xml, UTF_8);

			JAXBContext jc = JAXBContext.newInstance(obj);
			Unmarshaller unmarshaller = jc.createUnmarshaller();

			StringReader reader = new StringReader(xmlDecoded);

			return (T) unmarshaller.unmarshal(reader);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao converter o xml em objeto.", e);
		}
	}

	private XMLUtil() {
		super();
	}

}
