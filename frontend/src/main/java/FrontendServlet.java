import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontendServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private boolean connectToBackend(String backendIp, String backendPort) {
        String backendUrl = "http://" + backendIp + ":" + backendPort + "/"; // Replace with actual endpoint
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(backendUrl, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Frontend</h2>");
        out.println("<form method='post'>");
        out.println("Backend IP: <input type='text' name='backendIp'><br>");
        out.println("Backend Port: <input type='text' name='backendPort'><br>");
        out.println("<input type='submit' value='Connect'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String backendIp = request.getParameter("backendIp");
        String backendPort = request.getParameter("backendPort");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Frontend</h2>");
        out.println("Connecting to Backend Microservice at " + backendIp + ":" + backendPort + "<br>");
        boolean connectionSuccessful = connectToBackend(backendIp, backendPort);
        if (connectionSuccessful) {
            out.println("Connection Status: Success!");
        } else {
            out.println("Connection Status: Connection Failed!");
        }
        out.println("</body></html>");
    }
}
