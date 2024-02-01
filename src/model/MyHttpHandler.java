package model;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class MyHttpHandler implements HttpHandler {

    @Override

    public void handle(HttpExchange httpExchange) throws IOException {

        System.out.println("Handle");
        String requestParamValue = null;

        if ("GET".equals(httpExchange.getRequestMethod())) {

            requestParamValue = handleGetRequest(httpExchange);
            System.out.println(requestParamValue);

        } else if ("POST".equals(httpExchange.getRequestMethod())) {

            requestParamValue = handlePostRequest(httpExchange);

        }
        handleResponse(httpExchange, requestParamValue);

    }

    private String handlePostRequest(HttpExchange httpExchange) {
        //TODO
        System.out.println("Handle post");
        return ("TODO");
    }


    private String handleGetRequest(HttpExchange httpExchange) {

        System.out.println("Handle get");
        System.out.println(httpExchange.getRequestURI().toString());

        //if (httpExchange.getRequestURI().toString())


        return httpExchange.getRequestURI().toString();
    }


    private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {

        System.out.println("Handle response");
        OutputStream outputStream = httpExchange.getResponseBody();


        // encode HTML content

        String htmlResponse = "<html>" +
                "<body>" +
                "<h1>" +
                "Hello " +
                requestParamValue +
                "</h1>" +
                "</body>" +
                "</html>"
                // encode HTML content
                ;


        // this line is a must

        httpExchange.sendResponseHeaders(200, htmlResponse.length());

        outputStream.write(htmlResponse.getBytes());

        outputStream.flush();

        outputStream.close();

    }

}

