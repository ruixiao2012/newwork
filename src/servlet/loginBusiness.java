package servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import servlet.DataAccess;
public class loginBusiness
{
public String login(String username,String password)
{
String str=null;
Connection conn=null;
PreparedStatement prep =null;
ResultSet rs=null;
try
{
conn=DataAccess.getConnection();
prep=conn.prepareStatement("select username from user where username=? and password=?");
prep.setString(1,username);
prep.setString(2,password);
rs=prep.executeQuery();
if(rs.next()) {
str=rs.getString("username");
}
else {
	str="false";
}
}catch(SQLException e)
{
e.printStackTrace();
}finally{
try{
if (rs!=null)
{
rs.close();
rs=null;
}
if(prep!=null)
{
prep.close();
prep=null;
}
if(conn!=null)
{
conn.close();
conn=null;
}
}catch (SQLException e)
{
e.printStackTrace();
}
}
return str;
}
}

