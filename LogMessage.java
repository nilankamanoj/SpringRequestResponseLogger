
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogMessage {
    private int httpStatus;
    private String httpMethod;
    private String path;
    private String clientIp;
    private String response;
    private String authType;
    private String payload;

    @Override
    public String toString() {
        List<Integer> lengths = new ArrayList<>();
        lengths.add(path.length());
        lengths.add(payload.length());
        lengths.add(response.length());
        int length = Collections.max(lengths);
        String str = "\n\033[1;34m" + new String(new char[length + 10]).replace('\0', '=') + "\033[0m\n"
                + "\033[0;32mstatus\033[0m : " + httpStatus + " \033[0;32mhttpMethod\033[0m : '" + httpMethod + '\''
                + " \033[0;32mpath\033[0m : '" + path + '\'' + " \033[0;32mclientIp\033[0m : '" + clientIp + '\''
                + " \033[0;32mauthType\033[0m : '" + authType + '\'' + "\n\033[0;32mpayload\033[0m : '" + payload + '\''
                + "\n\033[0;32mresponse\033[0m : '" + response.replace("error", "\033[1;31merror\033[0m") + '\''
                + "\n\033[1;34m" + new String(new char[length + 10]).replace('\0', '=') + "\033[0m";
        return str;
    }

    public void setPayload(String payload) {
        this.payload = payload.replace("\n", "").replaceAll("  ", " ");
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
