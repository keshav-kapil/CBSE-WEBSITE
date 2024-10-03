import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class ShowData extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		 //String stu_name= req.getParameter("stu_name");
		// String stu_id = req.getParameter("stu_id");
		 //String marks1 = req.getParameter("math");
		 //String marks2 = req.getParameter("science");
		 //String marks3 = req.getParameter("english");
		 //String marks4 = req.getParameter("hindi");
		 //String marks5 = req.getParameter("computer");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca2426");
			Statement s = c.createStatement();
			// int x = s.executeUpdate("insert into student values ('"+stu_id+"','"+stu_name+"','"+marks1+"','"+marks2+"','"+marks3+"','"+marks4+"','"+marks5+"')");
			System.out.println("Show all Data");
			ResultSet rs = s.executeQuery("select * from stu_name  where stu_id='"+stu_id"'");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			
			out.println("<table bgcolor='red' border=1 width=200>");
			out.println("<tr>");
			
			for(int i=1;i<=rsmd.getColumnCount();i++){
				out.println("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("</tr>");
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
			
		}
		out.println("</table>");
			out.println("</body></html>");
	}
}