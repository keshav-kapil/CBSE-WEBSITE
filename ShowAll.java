/*
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class ShowAll extends HttpServlet
{
	public void service(HttpServletRequest req ,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		 //String stu_name = req.getParameter("stu_name");
         String stu_id = req.getParameter("stu_id");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca2426");
			Statement s = c.createStatement();
			String s1="select * from stu_name where stu_id='"+stu_id+"'";
			ResultSet rs=s.executeQuery(s1);
			ResultSetMetaData rsmd=rs.getMetaData();
			//ResultSet set = s.executeQuery("select * from stu_Name where stu_id= '"+stu_id+"','"+stu_name"','"+marks1+"','"+marks2+"','"+marks3+"','"+marks4+"','"+marks5+"'");
			set.next();
				out.println("<table align='center' cellpadding='5' cellspacing='5' bgcolor='green'><tr>");
				for(int i=1;i<=7;i++)
				{
					out.println("<td>"+set.getString(i)+"</td>");
				}
				out.println("</tr></table>");
		
			

				out.println("<a href='index.html'>back</a>");
				//req.Header("Refresh","5;index.html");
		
			
		}
		catch(Exception e)
		{
			out.println(e);
			
		}
		out.println("</table>");
			out.println("</body></html>");
	}
}
*/
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class ShowAll extends HttpServlet    /////SEARCH 
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException
{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
out.println("<html><body>");
String stu_id = req.getParameter("stu_id");

try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tushar");
Statement s= c.createStatement();
//int x =s.executeUpdate("delete from stu_Name where stu_name = '"+stu_name+"' and stu_id='"+stu_id+"'");
String s1 = "select * from stu_Name where stu_id='"+stu_id+"'";

ResultSet rs = s.executeQuery(s1);
 ResultSetMetaData rsmd = rs.getMetaData();

out.println("<table bgcolor='lightgreen' border=1 width=800 margin-top:100px>");
//out.println("<th>stu_name='"+stu_name+"','"+stu_id+"','"+marks1+"','"+marks2+"','"+marks3+"','"+marks4+"','"+marks+"'"</th>");
 out.println("<tr>");
 for(int i=1;i<=rsmd.getColumnCount();i++)
 {
 out.println("<th>"+rsmd.getColumnName(i)+"</th>");
}
if(rs.next()){
out.println("<tr>");
out.println("<td>"+rs.getString(1)+"</td>");
out.println("<td>"+rs.getString(2)+"</td>");
out.println("<td>"+rs.getString(3)+"</td>");
out.println("<td>"+rs.getString(4)+"</td>");
out.println("<td>"+rs.getString(5)+"</td>");
out.println("<td>"+rs.getString(6)+"</td>");
out.println("<td>"+rs.getString(7)+"</td>");
out.println("</tr>");
}else{
    System.out.println("User is not found");
}


}catch(Exception e){System.out.println(e);}


out.println("</table>");
out.println("</body></html>");
}
}