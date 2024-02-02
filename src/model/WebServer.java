package model;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

public class WebServer {

    private HttpServer server;
    private static WebServer instance;
    public static final Logger logger = Logger.getLogger("WebServerLogger");
    // variables to store the data from bots

    // number of macros running
    private int numberOfMacrosRunning = 0;
    private int lastMousePositionX = 0;
    private int lastMousePositionY = 0;
    // last screen capture
    private byte[] lastScreenCapture = null;

    // account logged
    private String accountLogged = null;

    public WebServer() throws IOException {
        // Constructor
        System.out.println("Create webserver");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext("/", new defaultPage());
        server.setExecutor(threadPoolExecutor);

        logger.info(" Server started on port 8001");

    }

    public void run() {

        server.start();
    }

    // load the default html page from contentes of index.html file in the resources
    // folder
    public String loadDefaultHtmlPage() {
        String indexHtml = "";
        try {
            indexHtml = Files.readString(Paths.get("www/index.html"));
        } catch (NoSuchFileException e) {
            // log that the file is not found and create a simple html page
            logger.warning("index.html not found");
            indexHtml = "<html><head><title>  TobLaba </title></head><body><h1> Under construction </h1></body></html>";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indexHtml;
    }

    // create the handler for / path
    public class defaultPage implements com.sun.net.httpserver.HttpHandler {
        @Override
        public void handle(com.sun.net.httpserver.HttpExchange exchange) throws IOException {
            String response = loadDefaultHtmlPage();
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();
        }
    }

}
