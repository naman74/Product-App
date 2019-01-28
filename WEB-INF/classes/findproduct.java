import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class findproduct extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res){
	  PrintWriter out = null;
	  try{
	      res.setContentType("text/html");
		  out=res.getWriter();
		  String u=req.getParameter("product_name");
		  out.println("<html> <body>");
		  out.println("<h1>Product Detail</h1>");
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","product_inf","product_inf");
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery("select * from product where product_name='"+u+"'");
          if(rs.next()){
                    out.println("name: <b>"+u+"</b><br/>");
					out.println("Price:<b>"+rs.getInt("price")+"</b><br/>");
					out.println("info: <b>"+rs.getString("info")+"</b><br/>");
					
					
					}else{
					      out.println("No Product Found");
						  }
						  out.println("</body></html>");
						  }catch(Exception ex){
						  out.println(ex);}
						  }
						}  
					
					