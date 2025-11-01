import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket serversocket = new ServerSocket(8888);
        System.out.println("Server Started");
        while (true) {
            try (Socket socket = serversocket.accept()) {
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String message = br.readLine();
                while (message != null && !message.isEmpty()) {
                    System.out.println(message);
                    message = br.readLine();
                }
                String body = "Hello World";
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Length: "+body.length()+"\r\n" +
                        "\r\n" +
                        body+"\r\n" +"Connection: close\r\n";
                OutputStream os = socket.getOutputStream();
                os.write(response.getBytes(StandardCharsets.UTF_8));
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
