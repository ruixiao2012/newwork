package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
public class XmlValidate
{
private static final String SCHEMALANG="http://www.w3.org/2001/XMLSchema";
public static Boolean xmlStringValidate(String xmlPath,String xsdPath)
{
boolean flag =false;
try
{
SchemaFactory factory=SchemaFactory.newInstance(SCHEMALANG);
String str=Thread.currentThread().getContextClassLoader().getResource("").getPath();
xsdPath=str+xsdPath;
xmlPath=str+xmlPath;
System.out.println(xsdPath);
System.out.println(xmlPath);
File schemaLocation=new File(xsdPath);
Schema schema=factory.newSchema(schemaLocation);
Validator validator=schema.newValidator();
Source source=new StreamSource(xmlPath);
validator.validate(source);

flag=true;
}catch(SAXException e)
{
System.out.println("the schema validate failed¡­");
e.printStackTrace();
}catch (IOException e)
{
System.out.println("create a exception in IO¡­");
e.printStackTrace();
}
return flag;
}
}
