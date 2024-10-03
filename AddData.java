import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class AddData extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		String stu_name = req.getParameter("stu_name");
		String stu_id = req.getParameter("stu_id");
		String marks1 = req.getParameter("math");
		String marks2 = req.getParameter("science");
		String marks3 = req.getParameter("english");
		String marks4 = req.getParameter("hindi");
		String marks5 = req.getParameter("computer");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca2426");
			Statement s = c.createStatement();
			int x = s.executeUpdate("insert into stu_Name values('"+stu_name+"','"+stu_id+"','"+marks1+"','"+marks2+"','"+marks3+"','"+marks4+"','"+marks5+"')");
			out.println("Data Insert Successfully"+x);
			
		}
		catch(Exception e)
		{
			out.println(e);
			
		}
		out.println("</table>");
			out.println("</body></html>");
	}
}