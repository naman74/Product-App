import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AddUser extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res){
	  PrintWriter out = null;
	  try{
	      res.setContentType("text/html");
		  out=res.getWriter();
		  String e=req.getParameter("email");
		  String n=req.getParameter("name");
		  String ph=req.getParameter("phone");
		  String a=req.getParameter("age");
		  String p=req.getParameter("password");
		  
		  out.println("<h1>Details</h1>");
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user_inf","user_inf");
          Statement st=con.createStatement();
		  int x=st.executeUpdate("insert into  userinf values ('"+e+"','"+n+"','"+ph+"',"+a+",'"+p+"')");
		  out.println("<html><body>");
		  
		  
          if(x!=0){
                    out.println("<b>INSERTION sucessfull</b> <br><br>");
					}else{
					      out.println("Data insertion Failed</b> <br><br>");
						  }
						  out.println("<a href ='index.html'> HOME </a>");
						  out.println("</body></html>");
						  out.close();
						  }catch(Exception ex){
						  out.println(ex);
						  out.close();
						  }
						  }
						}  
					
					