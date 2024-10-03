import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class DeleteData extends HttpServlet
{
	public void service(HttpServletRequest req ,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body>");
		 String stu_id = req.getParameter("stu_id");
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mca2426");
			Statement s = c.createStatement();
			int x = s.executeUpdate("delete from stu_Name where stu_id= '"+stu_id+"'");
			if(x==1)
			{
				out.println("Successfully Delete");
				out.println("<a href='index.html'>back</a>");
				//req.Header("Refresh","5;index.html");
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