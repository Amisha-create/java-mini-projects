import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        String n = request.getParameter("userName");  
        String p = request.getParameter("userPass");  
        String e = request.getParameter("userEmail");  
        String phone = request.getParameter("userPhone");  
        String gender = request.getParameter("userGender");  
        String address = request.getParameter("userAddress");  
        String c = request.getParameter("userCountry");  
        String[] courses = request.getParameterValues("course");
	out.println("<html><body>");
	out.println("<p>"+n+p+e+phone+gender+address+c+"</p>");
	out.println("</body></html>");
          
        try {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con = DriverManager.getConnection(  
                "jdbc:mysql://localhost:3307/db", "root", "");  
  
            PreparedStatement ps = con.prepareStatement(  
                "insert into student (name, password, email, phone, gender, address, country, courses) values (?, ?, ?, ?, ?, ?, ?, ?)");  
              
            ps.setString(1, n);  
            ps.setString(2, p);  
            ps.setString(3, e);  
            ps.setString(4, phone);  
            ps.setString(5, gender);  
            ps.setString(6, address);  
            ps.setString(7, c);  
            ps.setString(8, String.join(", ", courses));  
              
            int i = ps.executeUpdate();  
            if (i > 0){  
               out.print("You are successfully registered...");  
              }
        } catch (Exception e2) { 
            System.out.println(e2);
        }  
          
        out.close();  
    }  
}