# parserTestsJava
# Para gerar o parser.jar, fa�a o seguinte:

cd src/

javac $(find . -name '*.java')

jar -cvfm parser.jar MANIFEST.MF br/com/confidence/objecttoxml/*.class br/com/confidence/parser/Parser.class br/com/confidence/utils/*.class br/com/confidence/xmltoobject/*.class

# Agora � s� executados os comandos de gerar o parser. Exemplo build '20170828110946' no diret�rio '/home/buil-continua/resources-build-wildfly/rocket-engine/results/':

java -jar parser.jar 20170828110946 /home/buil-continua/resources-build-wildfly/rocket-engine/results/

# Ser� criado um arquivo 'testng-failures.xml' no diret�rio onde foi executado o parser.jar.
