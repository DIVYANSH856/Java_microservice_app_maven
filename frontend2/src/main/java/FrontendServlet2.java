import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontendServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Frontend HTML form to enter backend IP and port
        out.println("<html><body>");
        out.println("<h2>Frontend Microservice</h2>");
        out.println("<form method='post'>");
        out.println("Backend IP: <input type='text' name='backendIp'><br>");
        out.println("Backend Port: <input type='text' name='backendPort'><br>");
        out.println("<input type='submit' value='Connect'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the entered backend IP and port
        String backendIp = request.getParameter("backendIp");
        String backendPort = request.getParameter("backendPort");

        // TODO: Implement logic to connect to the backend microservice using backendIp and backendPort

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display the connection status
        out.println("<html><body>");
        out.println("<h2>Frontend Microservice</h2>");
        out.println("Connecting to Backend Microservice at " + backendIp + ":" + backendPort + "<br>");
        // TODO: Implement logic to connect to the backend microservice and display success or failure
        // Example: if connection is successful, display "Success!" otherwise display "Connection Failed!"
        out.println("Connection Status: Success!");
        out.println("</body></html>");
    }
}

