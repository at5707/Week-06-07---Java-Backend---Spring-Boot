import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
public class SimpleHttpServer {
	public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);

        server.createContext("/", new RootHandler());
        server.createContext("/headers", new HeaderHandler());
        server.createContext("/query", new QueryHandler());
        server.createContext("/post", new BodyHandler());

        server.setExecutor(null);
        server.start();
        System.out.println("Server started at http://localhost:8082/");
    }

    static class RootHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Welcome to Simple Java HTTP Server!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class HeaderHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            Headers headers = exchange.getRequestHeaders();
            StringBuilder response = new StringBuilder("Received Headers:\n");
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                response.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n");
            }
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }

    static class QueryHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String query = exchange.getRequestURI().getQuery();
            String response = "Query params: " + query;
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class BodyHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder body = new StringBuilder();
            try (InputStream is = exchange.getRequestBody()) {
                int i;
                while ((i = is.read()) != -1) {
                    body.append((char) i);
                }
            }
            String response = "Received Body: " + body.toString();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}