import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String dob = req.getParameter("dob");
        String age = req.getParameter("age");
        String city = req.getParameter("city");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String expectedUsername = "JatinKancharla";
        String expectedPassword = "qwerty";

        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            String key = firstName.substring(0, 2).toLowerCase() + dob;

            out.println("<h2>Login Successful</h2>");
            out.println("<p><strong>Name:</strong> " + firstName + " " + lastName + "</p>");
            out.println("<p><strong>Generated Key:</strong> " + key + "</p>");

            out.println("<h3>Other Details:</h3>");
            out.println("<ul>");
            out.println("<li>Age: " + age + "</li>");
            out.println("<li>City: " + city + "</li>");
            out.println("</ul>");
        } else {
            out.println("<h3 style='color:red;'>Invalid username or password</h3>");
            out.println("<a href='index.html'>Try Again</a>");
        }
    }
}