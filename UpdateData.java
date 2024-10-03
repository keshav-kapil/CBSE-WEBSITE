import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class UpdateData extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		 String stu_id = req.getParameter("stu_id");
		String stu_name = req.getParameter("stu_name");
		String marks1 = req.getParameter("math");
		String marks2 = req.getParameter("science");
		String marks3 = req.getParameter("english");
		String marks4 = req.getParameter("hindi");
		String marks5 = req.getParameter("computer");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca2426");
			Statement s = c.createStatement();
			int x = s.executeUpdate("update stu_Name set math='"+marks1+"',science='"+marks2+"',english='"+marks3+"',hindi='"+marks4+"',computer='"+marks5+"' where stu_id='"+stu_id+"'");
			
			out.println("Data Update Successfully"+x);
			
		}
		catch(Exception e)
		{
			out.println(e);
			
		}
		out.println("</table>");
		
			out.println("</body></html>");
	}
}