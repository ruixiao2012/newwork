package servlet;

import java.net.URL;
import java.util.Properties;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import servlet.XMLParser;
import servlet.XMLHandler;
public class XMLParser
{
private Properties props;
public Properties getProps()
{
return this.props;
}
public void parse(String filename) throws Exception
{
XMLHandler handler=new XMLHandler();
SAXParserFactory factory=SAXParserFactory.newInstance();
SAXParser parser=factory.newSAXParser();
URL confURL=XMLHandler.class.getClassLoader().getResource(filename);

parser.parse(confURL.toString(),handler);
props=handler.getProps();
}
}


