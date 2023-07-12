package org.example;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import org.json.JSONObject;
import java.util.concurrent.Executors;
import java.io.InputStream;

public class Server {

    public Server() {
        Con con = new Con();
    }

    public void startServer() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8135), 0);
        httpServer.createContext("/", new EcomHandler());
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
    }

    private class EcomHandler implements HttpHandler {
    }
}