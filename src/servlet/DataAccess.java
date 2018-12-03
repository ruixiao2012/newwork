package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataAccess
{
private static String driver;
private static String url;
private static String user;
private static String pwd;
private static String xmlPath="database.conf.xml";
private static String xsdPath="database.conf.xsd";
static
{
XMLParser databaseConfig=new XMLParser();
try
{
if(XmlValidate.xmlStringValidate(xmlPath,xsdPath))
{
databaseConfig.parse(xmlPath);
Properties dbProps=databaseConfig.getProps();
driver=dbProps.getProperty("driver");
url=dbProps.getProperty("user");
pwd=dbProps.getProperty("password");
}
}
catch(Exception e)
{
e.printStackTrace();
}
}

public static Connection getConnection()
{
	Connection conn=null;

try
{
	Class.forName(driver);	
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","aaa123");
}
catch(Exception ex)
{
	ex.printStackTrace();
}
	return conn;
}

}

