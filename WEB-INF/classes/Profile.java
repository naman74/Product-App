import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Profile extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res){
	  PrintWriter out = null;
	  try{
	      res.setContentType("text/html");
		  out=res.getWriter();
		  String e=req.getParameter("email");
		  String p=req.getParameter("password");
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user_inf","user_inf");
          Statement st=con.createStatement();
		  ResultSet rs=st.executeQuery("select * from userinf where email='"+e+"' and password='"+p+"'");
          if(rs.next()){
                    out.println("<html> <body>");
					out.println("Welcome: <b>"+rs.getString("name")+"</b> <a href='index.html'>LOGOUT</a>");
					out.println("<hr>");
					out.println("<form action ='AddProduct' method='post'>");
			        out.println("<b>Add Product<b><br>");
                    out.println("Product Name: <input type='text' name='product_name' required/><br><br>");
					out.println("Price: <input type='text' name='price' required/><br><br>");
					out.println("INFO: <input type='text' name='info' required/><br><br>");
					out.println("<input type='submit' value='submit'/><br><br>");
					out.println("</form>");
					out.println("</body></html>");
					out.close();
					}
				}
				catch(Exception ex){
						  out.println(ex);
						  out.close();
						  }
}
}
				