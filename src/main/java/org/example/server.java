package org.example;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class server {

    public server() {
        conn con = new conn();
    }

    public void startServer() throws IOException
    {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8135),0);
        httpServer.createContext( "/ecommerce", new ecommerceHandler());
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
    }
    public static class ecommerceHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            //post
            //get

            if("GET".equals(exchange.getRequestMethod())){
                OutputStream outputStream = exchange.getResponseBody();
                String tes = "Elmarosa";
                exchange.sendResponseHeaders(200, tes.length());
                outputStream.write(tes.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        }
    }

    {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8135), 0);
        httpServer.createContext("/", new EcomHandler());
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
    }

    public static class EcomHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            //post
            //get

            if("GET".equals(exchange.getRequestMethod())){
                OutputStream outputStream = exchange.getResponBody();
                String tes = "Elmarosa";
                exchange.sendResponseHeaders(200, tes.length());
                outputStream.write(tes.getBytes());
                outputStream.flush();
                outputStream.close();
            }
        }
    }
}