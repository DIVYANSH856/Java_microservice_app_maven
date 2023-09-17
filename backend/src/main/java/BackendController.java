import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
    @PostMapping("/")
    public String connectToBackend(@RequestBody ConnectionInfo connectionInfo) {
        // Extract the backend IP and port from the ConnectionInfo object
        String backendIp = connectionInfo.getBackendIp();
        String backendPort = connectionInfo.getBackendPort();
        // TODO: Implement logic to connect to the backend using the provided IP and port
        // For demonstration purposes, we will simply check if the IP and port are not empty
        if ("backend".equals(backendIp) && "8084".equals(backendPort)) {
            return "Success"; // Connection is successful
        } else {
            return "Connection Failed"; // Connection failed (IP or port is missing)
        }
    }
    // POJO class to represent the connection information from the frontend
    static class ConnectionInfo {
        private String backendIp;
        private String backendPort;
        // Getters and setters for backendIp and backendPort
        public String getBackendIp() {
            return backendIp;
        }
        public void setBackendIp(String backendIp) {
            this.backendIp = backendIp;
        }
        public String getBackendPort() {
            return backendPort;
        }
        public void setBackendPort(String backendPort) {
            this.backendPort = backendPort;
        }
    }
}


