package util.parser.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ConnectionHandler {
    public static String responseBodyToString(HttpURLConnection con) {

        try {
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String line = "";

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                String resultStr = sb.toString();
                resultStr.replaceAll("null", "");

                return sb.toString();

            } else {
                return con.getResponseCode() + " Error!";
            }
        } catch (IOException e) {
            return e + "Error!";
        }
    }
}
