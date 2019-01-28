import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AddProduct extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res){
	  PrintWriter out = null;
	  try{
	      res.setContentType("text/html");
		  out=res.getWriter();
		  String pr=req.getParameter("product_name");
		  String p=req.getParameter("price");
		  String i=req.getParameter("info");
		  
		  out.println("<h1>Details</h1>");
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","product_inf","product_inf");
          Statement st=con.createStatement();
		  int x=st.executeUpdate("insert into  product values ('"+pr+"',"+p+",'"+i+"')");
		  out.println("<html> <body>");
		  
		  
          if(x!=0){
                    out.println("<b>INSERTION sucessfull</b> <br><br>");
					}else{
					      out.println("Product insertion Failed</b> <br><br>");
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
					
					