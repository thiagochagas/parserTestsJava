package br.com.confidence.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.confidence.objecttoxml.Classe;
import br.com.confidence.objecttoxml.Include;
import br.com.confidence.objecttoxml.Methods;
import br.com.confidence.objecttoxml.Suite;
import br.com.confidence.utils.XMLUtil;
import br.com.confidence.xmltoobject.TestSuites;
import br.com.confidence.xmltoobject.Testcase;
import br.com.confidence.xmltoobject.Testsuite;

public class Parser {

	private static final String FILE = "/html/TESTS-TestSuites.xml";
	private static final String PATH_RESULT_DIRECTORY = "/home/buil-continua/rocket-engine-jboss10/results/";
	private static final String FILE_PATH = "/opt/rocket-engine/";
	private static final String FILE_NAME = "testng-failures.xml";

	public static void main(String[] args) throws FileNotFoundException, IOException{
		if (args.length == 0) {
			throw new RuntimeException("É necessário informar o arquivo para realizar o Parse!!!");
		}

		String path = args[0];
		String folder = PATH_RESULT_DIRECTORY;
		if (args.length == 2){
			folder = args[1];
		}
		Parser paser = new Parser();
		paser.tratarArquivo(path, folder);
	}


	private void tratarArquivo(String path, String folder) throws FileNotFoundException, IOException {
		String xml = getXml(path, folder);

		TestSuites testSuites = XMLUtil.xmlToObject(xml, TestSuites.class);

		gravarArquivo(criaArquivoComErros(testSuites));
	}


	private void gravarArquivo(Suite suiteErro) throws IOException {
		String file = FILE_NAME;
		File f = new File(file);
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(XMLUtil.objectToXML(suiteErro));
		bw.flush();
		bw.close();
		System.out.println("Arquivo salvo em:" + file);
	}

	private Suite criaArquivoComErros(TestSuites testSuites) {
		Suite suiteErro = new Suite();
		List<Classe> classes = new ArrayList<Classe>();
		for (Testsuite suite : testSuites.testSuites) {
			if(suite.falhou()){
				Classe classe = new Classe(suite.pacote + "." + suite.name);
				List<Include> includes = new ArrayList<Include>();
				Methods metodos = new Methods();
				for (Testcase caso : suite.testcases) {
					if(caso.possuiErro()){
						Include include = new Include(caso.name);
						includes.add(include);
					}
				}
				metodos.addIncludes(includes);
				classe.methods = metodos;
				classes.add(classe);
			}
		}

		suiteErro.test.classes.classe = classes;
		return suiteErro;
	}

	private String getXml(String path, String folder) throws FileNotFoundException,IOException {
		File f = new File( folder + path + FILE);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		StringBuffer xml = new StringBuffer();
		for (String x = br.readLine(); x != null; x = br.readLine()) {
			xml.append(x);
		}

		br.close();
		return xml.toString();
	}

}
