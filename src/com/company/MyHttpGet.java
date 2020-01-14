package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.*;

public class MyHttpGet {
    private String host;
    private int port;
    private String contextPath;
    private StringBuffer requestMessager;
    private Map<String, String> headers = new LinkedHashMap<>();
    private Map<String, String> params = new HashMap<>();

    public MyHttpGet(String address) throws MalformedURLException {
        URL url = new URL(address);
        this.port = url.getDefaultPort();
        this.host = url.getHost();
        this.contextPath = url.getPath();
        headers.put("Host", this.host);
    }

    public InputStream execute() throws IOException {
        StringBuffer requestMessage = new StringBuffer();
        List<String> pairs = new ArrayList<>();

        params.keySet().stream().forEach(
                key -> {
                    StringBuffer pair = new StringBuffer();
                    pair.append(key);
                    pair.append("=");
                    pair.append(params.get(key));
                    pairs.add(pair.toString());
                }
        );

        if (params.size() > 0) {
            this.contextPath = this.contextPath + "?" + String.join("&", (String[])pairs.toArray());
        }

        requestMessage.append("GET").append(this.contextPath).append("HTTP/1.1").append(System.getProperty("line.separator"));
        for(String key: headers.keySet()) {
            requestMessage.append(key);
            requestMessage.append(":");
            requestMessage.append(headers.get(key));
            requestMessage.append((System.getProperty("line.separator")));
        }

        requestMessage.append("\r\n");

        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(this.host, this.port);
        socket.connect(socketAddress);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(requestMessage.toString());
        bufferedWriter.flush();

        return socket.getInputStream();
    }

    public MyHttpGet addParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    public MyHttpGet addHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }
}
