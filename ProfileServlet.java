
package Test;


import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class ProfileServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("Link.html").include(request, response);  
          
        HttpSession session=request.getSession(false);  
        if(session!=null && session.getAttribute("name")!=null){  
        String name=(String)session.getAttribute("name");  
          
        out.print("Hello, "+name+" Welcome to Profile");  
        } 
        else 
        {  
            out.print("Please login first");  
            request.getRequestDispatcher("Login.jsp").include(request, response);  
        }  
        out.close();  
    }  
}  