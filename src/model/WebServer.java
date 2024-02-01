package model;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class WebServer {


    private HttpServer server;
    public WebServer() throws IOException {
        //Constructor
        System.out.println("Create webserver");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext("/", new  MyHttpHandler());
        server.setExecutor(threadPoolExecutor);

        //logger.info(" Server started on port 8001");

    }
    public void run(){

        server.start();
    }



}
