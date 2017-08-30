## Para gerar o parser.jar, faça o seguinte:

`unzip parserResultsRocketEngine.zip`

`cd src/`

`javac $(find . -name '*.java')`

`jar -cvfm parser.jar MANIFEST.MF br/com/confidence/objecttoxml/*.class br/com/confidence/parser/Parser.class br/com/confidence/utils/*.class br/com/confidence/xmltoobject/*.class`


## Agora é só executados os comandos de gerar o parser. Exemplo build '584397584395'

`java -jar parser.jar 584397584395 /home/buil-continua/resources-build-wildfly/rocket-engine/results/`


## Será criado um arquivo 'testng-failures.xml' no diretório onde foi executado o parser.jar.
