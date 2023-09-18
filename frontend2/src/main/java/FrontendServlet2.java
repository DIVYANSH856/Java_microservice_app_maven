import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@WebServlet("/frontend2")
public class FrontendServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Frontend Microservice 2</h2>");
        out.println("<form action=\"\" method=\"post\">");
        out.println("Backend IP: <input type=\"text\" name=\"backendIp\"><br>");
        out.println("Backend Port: <input type=\"text\" name=\"backendPort\"><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String backendIp = request.getParameter("backendIp");
        String backendPort = request.getParameter("backendPort");
        String backendUrl = "http://" + backendIp + ":" + backendPort + "/hello";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Frontend Microservice 2</h2>");
        out.println("<p>Calling Backend Microservice:</p>");

        String backendResponse = callBackendService(backendIp, backendPort);

        if (backendResponse != null) {
            out.println("<p>Response from Backend: " + backendResponse + "</p>");
        } else {
            out.println("<p>Error connecting to Backend</p>");
        }
        
        out.println("</body></html>");
    }

    private String callBackendService(String backendIp, String backendPort) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String backendUrl = "http://" + backendIp + ":" + backendPort + "/hello";
        try {
            HttpGet httpGet = new HttpGet(backendUrl);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            response.close();
            httpClient.close();
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error connecting to Backend";
        }
    }
}

